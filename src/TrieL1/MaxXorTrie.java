package TrieL1;

class MaxXorTrie {
    static void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) node.child[bit] = new TrieNode();
            node = node.child[bit];
        }
    }

    static int query(TrieNode root, int num) {
        TrieNode node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (node.child[opposite] != null) {
                xor |= (1 << i);
                node = node.child[opposite];
            } else {
                node = node.child[bit];
            }
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        TrieNode root = new TrieNode();
        for (int num : nums) insert(root, num);

        int max = 0;
        for (int num : nums) max = Math.max(max, query(root, num));

        System.out.println("Maximum XOR = " + max);
    }

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }
}
