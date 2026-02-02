package CodingShuttle.StringTrie;

public class WordBreakProblem {
    public static void main(String[] args) {
        String[] a = {"b", "br", "break", "pro", "blem", "problem", "this"};
        String s = "breakbrbrbrbrb";

        System.out.println(wordBreakUsingTrie(s, a));
    }

    static boolean wordBreakUsingTrie(String s, String[] a) {
        Trie trie = new Trie();
        for (String x : a) trie.insert(x);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                TrieNode node = trie.root;
                for (int j = i; j < n; j++) {
                    if (node == null) break;
                    node = node.children[s.charAt(j) - 'a'];

                    if (node != null && node.isEnd) {
                        dp[j + 1] = true;
                    }
                }
            }
        }
        return dp[n];
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}
