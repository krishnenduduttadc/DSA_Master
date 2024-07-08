package GraphL2;

import java.io.IOException;

public class ColoringABorderMedium {
    public static void coloring_border(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
    }

    static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void dfs(int[][] grid, int row, int col, int clr) {
        grid[row][col] = -clr;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int rowdash = row + dirs[i][0];
            int coldash = col + dirs[i][1];

            if (rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length
                    || Math.abs(grid[rowdash][coldash]) != clr) {
                continue;
            }

            count++;

            if (grid[rowdash][coldash] == clr) {
                dfs(grid, rowdash, coldash, clr);
            }
        }

        if (count == 4) {
            grid[row][col] = clr;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // Hardcoded input
        int m = 4;
        int n = 4;
        int[][] arr = {
                { 2, 1, 3, 4 },
                { 1, 2, 2, 2 },
                { 3, 2, 2, 2 },
                { 1, 2, 2, 2 }
        };
        int row = 1;
        int col = 1;
        int color = 3;

        coloring_border(arr, row, col, color);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
