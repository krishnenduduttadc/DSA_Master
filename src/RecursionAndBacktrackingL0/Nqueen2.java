package RecursionAndBacktrackingL0;

import java.util.Arrays;

public class Nqueen2 {
    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for (char i[] : board)
            Arrays.fill(i, '.');
        return dfs(0, board);
    }

    public int dfs(int row, char board[][]) {
        if (row == board.length)
            return 1;
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                count += dfs(row + 1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }

    public boolean isSafe(char board[][], int row, int col) {
        int dupRow = row;
        int dupCol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while (row >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
        }
        row = dupRow;
        col = dupCol;
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 'Q') return false;
            row--;
            col++;
        }
        return true;
    }
}
