package TrieL1;

public class Trie {

        static  class TrieNode {
            char data;
            boolean isTerminating;
            TrieNode children[];

            public TrieNode(char data) {
                this.data = data;
                isTerminating = false;
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode('\0');
        }

        public boolean search(String word) {
            return search(root, word);
        }

        private boolean search(TrieNode root, String word) {
            if (word.length() == 0) {
                return root.isTerminating;
            }
            int childIndex = word.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if (child == null) {
                return false;
            }
            return search(child, word.substring(1));
        }

        public void add(String word) {
            add(root, word);
        }

        public void add(TrieNode root, String word) {
            if (word.length() == 0) {
                root.isTerminating = true;
                return;
            }
            int childIndex = word.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if (child == null) {
                child = new TrieNode(word.charAt(0));
                root.children[childIndex] = child;
            }
            add(child, word.substring(1));
        }

        public static void main(String[] args) {
            Trie t = new Trie();
            t.add("this");
            t.add("news");
            System.out.println(""+t.search("news"));
        }



}
