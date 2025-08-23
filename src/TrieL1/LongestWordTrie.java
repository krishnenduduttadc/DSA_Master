package TrieL1;

import java.util.LinkedList;
import java.util.Queue;

class LongestWordTrie {
    static String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.isEnd = true;
            node.word = word;
        }

        String res = "";
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TrieNode node = q.poll();
            for (int i = 25; i >= 0; i--) {
                TrieNode child = node.children[i];
                if (child != null && child.isEnd) {
                    q.add(child);
                    if (child.word.length() > res.length() ||
                            (child.word.length() == res.length() && child.word.compareTo(res) < 0)) {
                        res = child.word;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world", "banana"};
        System.out.println("Longest word = " + longestWord(words));
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        String word;
    }
}

