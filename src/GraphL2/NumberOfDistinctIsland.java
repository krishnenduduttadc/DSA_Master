package GraphL2;

import java.util.HashSet;

public class NumberOfDistinctIsland {
    public static void main(String[] args) {
        // Hardcoded input for the grid
        int[][] arr = {
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        // Print the number of distinct islands
        System.out.println(numDistinctIslands(arr));
    }

    public static StringBuilder psf = new StringBuilder();

    static void dfs(int[][] arr, int row, int col) {
        arr[row][col] = 0;
        if (row - 1 >= 0 && arr[row - 1][col] == 1) {
            psf.append("u");
            dfs(arr, row - 1, col);
        }
        if (col + 1 < arr[0].length && arr[row][col + 1] == 1) {
            psf.append("r");
            dfs(arr, row, col + 1);
        }
        if (row + 1 < arr.length && arr[row + 1][col] == 1) {
            psf.append("d");
            dfs(arr, row + 1, col);
        }
        if (col - 1 >= 0 && arr[row][col - 1] == 1) {
            psf.append("l");
            dfs(arr, row, col - 1);
        }
        psf.append("a");
    }

    public static int numDistinctIslands(int[][] arr) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    psf = new StringBuilder();
                    psf.append("x");
                    dfs(arr, i, j);
                    set.add(psf.toString());
                }
            }
        }
        return set.size();
    }
}
