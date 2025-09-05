package LeetCodePatterns.RandB;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch solver = new WordSearch();

        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("Word 'ABCCED': " + solver.exist(board1, "ABCCED")); // true
        System.out.println("Word 'SEE': " + solver.exist(board1, "SEE"));       // true
        System.out.println("Word 'ABCB': " + solver.exist(board1, "ABCB"));     // false
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, i + 1, j, word, index + 1) || dfs(board, i - 1, j, word, index + 1) ||
                dfs(board, i, j + 1, word, index + 1) || dfs(board, i, j - 1, word, index + 1);

        board[i][j] = temp;

        return found;
    }
}
