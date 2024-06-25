package MatrixL1;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS_max_in_8_direction_travel_and_collect_values {

     static class Pair {
        int i;
        int j;
        int v;
        String psf;

        Pair(int i, int j, int v, String psf) {
            this.i = i;
            this.j = j;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 6, 3, 4, 5},
                {4, 5, 6, 9, 1},
                {7, 8, 6, 6, 5},
                {7, 2, 9, 6, 1},
                {7, 8, 3, 6, 5}
        };
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        q.add(new Pair(0, 0, mat[0][0], "(0,0)@"+mat[0][0]));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int i = rem.i;
            int j = rem.j;
            if (rem.i == mat.length - 1 && rem.j == mat[0].length - 1) {
                System.out.println("Path is " + rem.psf);
                System.out.println("value is " + rem.v);
                break;
            }


            int[] di = {-1,-1,-1,0,1,1,1,0}; // Right, Down, Left, Up
            int[] dj = {-1,0,1,1,1,0,-1,-1};

            int nextI = -1;
            int nextJ = -1;
            int max = Integer.MIN_VALUE;

            for (int k = 0; k < 8; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (ni >= 0 && ni < mat.length && nj >= 0 && nj < mat[0].length && !visited[ni][nj]) {
                    if (mat[ni][nj] > max) {
                        nextI = ni;
                        nextJ = nj;
                        max = mat[ni][nj];
                    }
                }
            }

            if (nextI != -1 && nextJ != -1) {
                q.add(new Pair(nextI, nextJ, rem.v + max, rem.psf + "->(" + nextI + "," + nextJ + ")@"+max));
                visited[nextI][nextJ] = true;
            }
        }
    }
}
