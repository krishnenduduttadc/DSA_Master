package GraphL3;

import java.util.Arrays;
import java.util.PriorityQueue;

class PathwithMaxEffort {

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        PathwithMaxEffort obj = new PathwithMaxEffort();

        System.out.println(obj.minimumEffort(heights));
    }

    public int minimumEffort(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq =
                new PriorityQueue<>((a, b) -> a.effort - b.effort);

        pq.offer(new Cell(0, 0, 0));
        dist[0][0] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            int row = curr.row;
            int col = curr.col;
            int effort = curr.effort;

            if (row == n - 1 && col == m - 1)
                return effort;

            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m) {

                    int newEffort = Math.max(
                            effort,
                            Math.abs(heights[row][col] - heights[newRow][newCol])
                    );

                    if (newEffort < dist[newRow][newCol]) {

                        dist[newRow][newCol] = newEffort;
                        pq.offer(new Cell(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return 0;
    }

    static class Cell {
        int row, col, effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
}