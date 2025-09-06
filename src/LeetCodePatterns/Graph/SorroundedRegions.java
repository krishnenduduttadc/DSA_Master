package LeetCodePatterns.Graph;

import java.util.Arrays;

public class SorroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        SorroundedRegions solution = new SorroundedRegions();
        solution.solve(board);

        System.out.println("Board after solve:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Mark all 'O' as temporary 'P'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'P';
                }
            }
        }

        // Restore 'O's connected to border
        for (int j = 0; j < n; j++) dfsCore(0, j, board);
        for (int j = 0; j < n; j++) dfsCore(m - 1, j, board);
        for (int i = 0; i < m; i++) dfsCore(i, 0, board);
        for (int i = 0; i < m; i++) dfsCore(i, n - 1, board);

        // Convert remaining 'P' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfsCore(int row, int col, char[][] board) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'P') {
            board[row][col] = 'O';
            dfsCore(row - 1, col, board);
            dfsCore(row + 1, col, board);
            dfsCore(row, col - 1, board);
            dfsCore(row, col + 1, board);
        }
    }
}
