package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
//                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
//                " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi" +
//                " ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit" +
//                " in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint" +
//                " occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        String text = "Lorem ipsum dolor sit amet";

        HashMap<Character, Integer> charsFrequencies = Utils.getCharsFrequenciesMap(text);

        ArrayList<CharTreeNode> charNodesList = Utils.getCharTreeNodesList(charsFrequencies);

        CharTreeNode huffmanTree = Utils.applyHuffmanAlgorithm(charNodesList);

        TreeMap<Character, String> codeTree = new TreeMap<>();
        for (Character c : charsFrequencies.keySet()) {
            codeTree.put(c, huffmanTree.getCharCode(c, ""));
        }

        String encodedLine = Utils.encodeLineWithCodeTree(text, codeTree);
        System.out.println(encodedLine);

        String decodedLine = Utils.decodeHuffmansCode(encodedLine, huffmanTree);
        System.out.println(decodedLine);

    }
}