package RecursionAndBacktrackingL3;

import java.util.Arrays;

public class NQueen {

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        backtrack(board, 0);
    }

    public static void backtrack(char[][] board, int row) {

        if (row == board.length) {
            printBoard(board);
            System.out.println();
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                backtrack(board, row + 1);

                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {

        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
    }

}
