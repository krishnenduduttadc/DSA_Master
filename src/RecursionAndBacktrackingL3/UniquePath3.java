package RecursionAndBacktrackingL3;

public class UniquePath3 {


    static int result = 0;
    static int empty = 0;

    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        int startX = 0, startY = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) empty++;
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }

        backtrack(grid, startX, startY, -1);

        System.out.println(result);
    }

    public static void backtrack(int[][] grid, int x, int y, int count) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                || grid[x][y] == -1)
            return;

        if (grid[x][y] == 2) {
            if (count == empty)
                result++;
            return;
        }

        grid[x][y] = -1;

        backtrack(grid, x + 1, y, count + 1);
        backtrack(grid, x - 1, y, count + 1);
        backtrack(grid, x, y + 1, count + 1);
        backtrack(grid, x, y - 1, count + 1);

        grid[x][y] = 0;
    }

}
