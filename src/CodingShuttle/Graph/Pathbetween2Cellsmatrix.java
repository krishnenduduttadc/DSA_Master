package CodingShuttle.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Pathbetween2Cellsmatrix {
    public static void main(String[] args) {
        int[][] a = {{0, 3, 1, 0},
                {3, 0, 3, 3},
                {2, 3, 0, 3},
                {0, 3, 0, 3}};

        System.out.println(pathExistsInMatrix(a));
    }

    static boolean pathExistsInMatrix(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 1) {
                    return bfs(a, i, j);
                }
            }
        }
        return false;
    }

    static boolean bfs(int[][] a, int i, int j) {
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] vis = new boolean[a.length][a[0].length];

        queue.add(new Cell(i, j));

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            if (a[cur.x][cur.y] == 2) return true;

            vis[cur.x][cur.y] = true;

            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};

            for (int ind = 0; ind < 4; ind++) {
                int nextI = cur.x + x[ind];
                int nextJ = cur.y + y[ind];

                if (isSafe(a, nextI, nextJ) && !vis[nextI][nextJ]) queue.add(new Cell(nextI, nextJ));
            }
        }
        return false;
    }

    static boolean isSafe(int[][] a, int i, int j) {
        int row = a.length;
        int col = a[0].length;

        return i >= 0 && i < row && j >= 0 && j < col && a[i][j] != 0;
    }

    static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
