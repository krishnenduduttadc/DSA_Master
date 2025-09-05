package LeetCodePatterns.RandB;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    List<List<String>> solutions;

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        int n1 = 4;
        System.out.println("Solutions for N=4:");
        for (List<String> sol : solver.solveNQueens(n1)) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0);

        return solutions;
    }

    public void backtrack(char[][] board, int row) {
        if (row == board.length) {
            solutions.add(convertToSolution(board));
        } else {
            for (int i = 0; i < board[0].length; i++) {
                if (isSafe(board, row, i)) {
                    board[row][i] = 'Q';
                    backtrack(board, row + 1);
                    board[row][i] = '.';
                }
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board[0].length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    private List<String> convertToSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}
