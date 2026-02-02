package CodingShuttle.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class WaterFlow {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(flowWater(a));
    }

    static int flowWater(int[][] a) {
        int row = a.length;
        int col = a[0].length;

        int[][] ans = new int[row][col];
        Queue<Cell> queue = new LinkedList<>();

        // Starting points for the "Blue river"
        for (int i = 0; i < col; i++) {
            queue.add(new Cell(0, i));
        }
        for (int i = 1; i < row; i++) {
            queue.add(new Cell(i, 0));
        }
        bfsFlowWater(a, ans, queue); // blue river

        // Clear queue and start for the "Red river"
        queue.clear();
        for (int i = 0; i < col; i++) {
            queue.add(new Cell(row - 1, i));
        }
        for (int i = 1; i < row; i++) {
            queue.add(new Cell(i, col - 1));
        }
        bfsFlowWater(a, ans, queue); // red river

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ans[i][j] == 2) count++;
            }
        }
        return count;
    }

    static void bfsFlowWater(int[][] a, int[][] ans, Queue<Cell> queue) {
        int row = a.length;
        int col = a[0].length;

        boolean[][] vis = new boolean[row][col];

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();

            if (vis[cur.x][cur.y]) continue;
            vis[cur.x][cur.y] = true;
            ans[cur.x][cur.y]++;

            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};

            for (int ind = 0; ind < 4; ind++) {
                int nextI = cur.x + x[ind];
                int nextJ = cur.y + y[ind];

                if (isSafeWaterFlow(a, nextI, nextJ) && !vis[nextI][nextJ] && a[nextI][nextJ] >= a[cur.x][cur.y])
                    queue.add(new Cell(nextI, nextJ));
            }
        }
    }

    static boolean isSafeWaterFlow(int[][] a, int i, int j) {
        int row = a.length;
        int col = a[0].length;
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
