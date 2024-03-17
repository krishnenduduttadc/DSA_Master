package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS_unconditional_travel {
    static class Pair{
        int i;
        int j;
        int v;
        Pair(int i,int j,int v){
            this.i=i;
            this.j=j;
            this.v=v;
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {4, 5, 6, 9, 1},
                {7, 8, 6, 6, 5},
                {7, 2, 9, 6, 1},
                {7, 8, 3, 6, 5}
        };
        Queue<Pair> q=new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        q.add(new Pair(0,0,mat[0][0]));
        Queue<Pair> path = new LinkedList<>();
        visited[0][0] = true;
        while(!q.isEmpty()){
            Pair p=q.poll();
            path.add(p);
            int i = p.i;
            int j = p.j;
            int v = p.v;
            if (i == mat.length-1 && j == mat[0].length-1) {
                System.out.println("Reached destination at (" + i + ", " + j + ") with value " + v);
                System.out.println("Travel path:");
                while (!path.isEmpty()) {
                    Pair step = path.poll();
                    System.out.println("Move to (" + step.i + ", " + step.j + ") with value " + step.v);
                }
                break;
            }

            int[] di = {-1, 0, 1, 0}; // Changes in row
            int[] dj = {0, 1, 0, -1}; // Changes in column

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (ni >= 0 && ni < mat.length && nj >= 0 && nj < mat[0].length && !visited[ni][nj]) {
                    q.add(new Pair(ni, nj, mat[ni][nj]));
                    visited[ni][nj] = true;
                }
            }

        }

    }
}
