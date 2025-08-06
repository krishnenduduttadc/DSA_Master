package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        NQueen obj = new NQueen();
        int n = 4;

        List<List<String>> solutions = obj.solveNQueens(n);

        System.out.println("All distinct solutions for " + n + "-Queens problem:");
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }

        System.out.println("Total solutions: " + solutions.size());
    }

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (char[] i : board)
            Arrays.fill(i, '.');
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }

    public void dfs(int row, char board[][], List<List<String>> res) {
        if (row == board.length) {
            res.add(counter(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                dfs(row + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col) {
        int dupRow = row;
        int dupCol = col;

        // Check upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Check above
        while (row >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
        }

        row = dupRow;
        col = dupCol;

        // Check upper-right diagonal
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 'Q') return false;
            row--;
            col++;
        }

        return true;
    }

    public List<String> counter(char board[][]) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
