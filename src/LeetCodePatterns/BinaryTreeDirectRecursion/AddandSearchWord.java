package LeetCodePatterns.BinaryTreeDirectRecursion;

public class AddandSearchWord {


    private TrieNode root;

    public AddandSearchWord() {
        root = new TrieNode();
    }

    // Quick demo
    public static void main(String[] args) {
        AddandSearchWord dict = new AddandSearchWord();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

        System.out.println(dict.search("pad")); // false
        System.out.println(dict.search("bad")); // true
        System.out.println(dict.search(".ad")); // true
        System.out.println(dict.search("b..")); // true
    }

    // Adds a word into the data structure
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any letter
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    private boolean searchHelper(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, child, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            return searchHelper(word, node.children[idx], index + 1);
        }
    }

    // Inner TrieNode class
    private class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
}


