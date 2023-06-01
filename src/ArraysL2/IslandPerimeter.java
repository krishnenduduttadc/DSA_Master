package ArraysL2;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0},
                {1, 1, 1},
                {0, 1, 0},
                {0, 1, 0}
        };
        int p=perimeter(grid);
        System.out.println(p);
    }

    static int perimeter(int[][] grid) {
        int p = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    p = p + 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        p = p - 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        p = p - 2;
                    }
                }

            }
        }
        return p;
    }
}
