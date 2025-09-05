package LeetCodePatterns.RandB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2 {


    private ArrayList<String> result = new ArrayList<>();

    // Main method to test
    public static void main(String[] args) {
        WordSearch2 solver = new WordSearch2();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain", "hklf", "hf"};

        List<String> foundWords = solver.findWords(board, words);
        System.out.println("Found words: " + foundWords);
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char letter : word.toCharArray()) {
                node.children.putIfAbsent(letter, new TrieNode());
                node = node.children.get(letter);
            }
            node.isEnd = true;
        }

        // Step 2: Backtracking from every cell
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    search(board, row, col, root, Character.toString(board[row][col]));
                }
            }
        }

        return this.result;
    }

    private void search(char[][] board, int row, int col, TrieNode parent, String word) {
        char letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if we found a word
        if (currNode.isEnd) {
            currNode.isEnd = false; // avoid duplicates
            this.result.add(word);
        }

        // mark visited
        board[row][col] = '#';

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(board[newRow][newCol])) {
                search(board, newRow, newCol, currNode, word + board[newRow][newCol]);
            }
        }

        // restore
        board[row][col] = letter;
    }

    // Trie node definition
    static class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

}
