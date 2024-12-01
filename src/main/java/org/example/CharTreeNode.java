package org.example;

public class CharTreeNode implements Comparable<CharTreeNode> {

    Character character;
    int freq;
    CharTreeNode leftNode;
    CharTreeNode rightNode;


    public CharTreeNode(Character character, int freq) {
        this.character = character;
        this.freq = freq;
    }

    public CharTreeNode(Character character, int freq, CharTreeNode leftNode, CharTreeNode rightNode) {
        this.character = character;
        this.freq = freq;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public int compareTo(CharTreeNode o) {
        return o.freq - this.freq;
    }

    public String getCharCode(Character c, String parentCode) {
        if (character == c) {
            return parentCode;
        } else {
            if (leftNode != null) {
                String code = leftNode.getCharCode(c, parentCode + 0);

                if (code != null) return code;
            }
            if (rightNode != null) {
                String code = rightNode.getCharCode(c, parentCode + 1);

                if (code != null) return code;
            }
        }
        return null;
    }
}

