package org.example;

import java.util.*;

public class Utils {

    public static HashMap<Character, Integer> getCharsFrequenciesMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (map.containsKey(c)) {
                Integer charFreq = map.get(c);
                map.put(c, charFreq + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static ArrayList<CharTreeNode> getCharTreeNodesList(HashMap<Character, Integer> map) {
        ArrayList<CharTreeNode> resultList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            resultList.add(new CharTreeNode(entry.getKey(), entry.getValue()));
        }
        return resultList;
    }

    public static CharTreeNode applyHuffmanAlgorithm(ArrayList<CharTreeNode> nodesList) {
        while (nodesList.size() > 1) {

            Collections.sort(nodesList);

            CharTreeNode leftSmallerNode = nodesList.remove(nodesList.size() - 1);
            CharTreeNode rightSmallerNode = nodesList.remove(nodesList.size() - 1);

            CharTreeNode parentNode = new CharTreeNode(
                    null,
                    leftSmallerNode.freq + rightSmallerNode.freq,
                    leftSmallerNode,
                    rightSmallerNode
            );
            nodesList.add(parentNode);
        }
        return nodesList.get(0);
    }

    public static String decodeHuffmansCode(String encodedLine, CharTreeNode tree) {
        StringBuilder decodedLine = new StringBuilder();

        CharTreeNode node = tree;
        for (int i = 0; i < encodedLine.length(); i++) {
            node = encodedLine.charAt(i) == '0' ? node.leftNode : node.rightNode;
            if (node.character != null) {
                decodedLine.append(node.character);
                node = tree;
            }
        }
        return decodedLine.toString();
    }

    public static String encodeLineWithCodeTree(String line, TreeMap<Character, String> codeTree) {
        StringBuilder encodedLine = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            encodedLine.append(codeTree.get(line.charAt(i)));
        }
        return encodedLine.toString();
    }
}
