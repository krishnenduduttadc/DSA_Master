package GraphL2;
import java.util.LinkedList;

public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        // Hardcoded input values
        int n = 3; // Size of the grid
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 1}
        };

        System.out.println(maxDistance(grid));
    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int maxDistance(int[][] grid) {
        LinkedList<Pair> q = new LinkedList<>();

        // Enqueue all land cells initially
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.addLast(new Pair(i, j));
                }
            }
        }

        if (q.size() == 0 || q.size() == grid.length * grid[0].length) {
            return -1; // If there are no water cells or all are land
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int level = -1;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();

            while (size-- > 0) {
                Pair current = q.removeFirst();

                for (int[] dir : dirs) {
                    int row_dash = current.row + dir[0];
                    int col_dash = current.col + dir[1];

                    if (row_dash < 0 || col_dash < 0 || row_dash >= grid.length || col_dash >= grid[0].length || grid[row_dash][col_dash] == 1) {
                        continue; // Skip if out of bounds or cell is land
                    }

                    q.addLast(new Pair(row_dash, col_dash));
                    grid[row_dash][col_dash] = 1; // Mark as visited
                }
            }
        }

        return level;
    }
}
