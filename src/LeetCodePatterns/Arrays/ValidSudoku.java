package LeetCodePatterns.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();

        char[][] validBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '5', '.', '1', '9', '5', '.', '.', '.'}, // duplicate '5' in row
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Valid board check: " + solution.isValidSudoku(validBoard));   // Expected: true
        System.out.println("Invalid board check: " + solution.isValidSudoku(invalidBoard)); // Expected: false
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] gridSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            gridSet[i] = new HashSet<>();

        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int gridNo = (i / 3) * 3 + (j / 3);

                if (board[i][j] != '.') {
                    boolean isPresentInRow = rowSet[i].contains(board[i][j]);
                    boolean isPresentInCol = colSet[j].contains(board[i][j]);
                    boolean isPresentInGrid = gridSet[gridNo].contains(board[i][j]);

                    if (isPresentInRow || isPresentInCol || isPresentInGrid) {
                        return false;
                    }

                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    gridSet[gridNo].add(board[i][j]);
                }
            }
        }

        return true;

    }
}
