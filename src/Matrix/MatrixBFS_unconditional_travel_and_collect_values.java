package Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS_unconditional_travel_and_collect_values {
    static class Pair{
        int i;
        int j;
        int v;
        String psf;
        Pair(int i,int j,int v, String psf){
            this.i=i;
            this.j=j;
            this.v=v;
            this.psf=psf;
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
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        q.add(new Pair(0, 0, mat[0][0],"(0,0)"));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Pair rem=q.poll();
            int i=rem.i;
            int j=rem.j;
            int v=rem.v;
            if(rem.i==mat.length-1 && rem.j==mat[0].length-1){
                System.out.println("Path is "+rem.psf);
                System.out.println("value is "+rem.v);
                break;
            }

            int[] di={-1,0,1,0};
            int[] dj={0,1,0,-1};
            for (int k = 0; k <4 ; k++) {
                int ci=i+di[k];
                int cj=j+dj[k];
                if(ci>=0 && ci<=mat.length-1 && cj>=0 && cj<=mat[0].length-1 && visited[ci][cj]==false){
                    q.add(new Pair(ci,cj,rem.v+mat[ci][cj],rem.psf+"->("+(ci+","+cj+")")));
                    visited[ci][cj]=true;
                }
            }
        }
    }
}
