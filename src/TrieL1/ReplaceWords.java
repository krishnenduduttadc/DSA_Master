package TrieL1;

import java.util.Arrays;
import java.util.List;

class ReplaceWords {
    static void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.word = word;
    }

    static String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dict) insert(root, word);

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null || node.word != null) break;
                node = node.children[idx];
            }
            sb.append(node.word != null ? node.word : word).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println("Replaced: " + replaceWords(dict, sentence));
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}

