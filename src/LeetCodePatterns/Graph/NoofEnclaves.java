package LeetCodePatterns.Graph;

public class NoofEnclaves {
    public static int numEnclaves(int[][] grid) {
        // Remove lands connected to the border
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) dfs(grid, i, grid[0].length - 1);
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j);
            if (grid[grid.length - 1][j] == 1) dfs(grid, grid.length - 1, j);
        }

        int enclaveCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    enclaveCount += dfs(grid, i, j);
                }
            }
        }
        return enclaveCount;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int result = numEnclaves(grid);
        System.out.println("Number of enclaves: " + result);
    }
}
