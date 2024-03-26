package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS_2_direction_manual_move {
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
                {23, 18, 12, 11, 16},
                {21, 12, 11, 10, 13},
                {12, 16, 11, 10, 8},
                {12, 9, 6, 9, 8},
                {8, 6, 6, 5, 1}
        };
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        q.add(new Pair(0, 0, mat[0][0], ""));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int i = rem.i;
            int j = rem.j;
            int v = rem.v;
            String psf = rem.psf;


            if (i == mat.length - 1 && j == mat[0].length - 1) {
                System.out.println(psf);
            } else if (i == mat.length - 1) {
                q.add(new Pair(i, j + 1, v + mat[i][j + 1], psf + "H"));
            } else if (j == mat[0].length - 1) {
                q.add(new Pair(i + 1, j, v + mat[i + 1][j], psf + "V"));
            } else {
                if (mat[i][j + 1] < mat[i + 1][j]) {
                    q.add(new Pair(i, j + 1, v + mat[i][j + 1], psf + "H"));
                } else if (mat[i][j + 1] > mat[i + 1][j]) {
                    q.add(new Pair(i + 1, j, v + mat[i + 1][j], psf + "V"));
                } else {
                    q.add(new Pair(i + 1, j, v + mat[i + 1][j], psf + "V"));
                    q.add(new Pair(i, j + 1, v + mat[i][j + 1], psf + "H"));
                }
            }
        }
    }
}
