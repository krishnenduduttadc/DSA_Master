package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ZeroOneMatrix {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        int[][] ans = updateMatrix(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] updateMatrix(int[][] matrix) {
        //write your code here
        LinkedList<Pair> q=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    q.addLast(new Pair(i,j));
                }else{
                    matrix[i][j]=-1;
                }
            }
        }

        while(q.size()>0){
            Pair rem=q.removeFirst();
            for(int i=0;i<dirs.length;i++){
                int rowdash=rem.x+dirs[i][0];
                int coldash=rem.y+dirs[i][1];

                if(rowdash>=0 && coldash>=0 && rowdash<matrix.length && coldash<matrix[0].length
                        && matrix[rowdash][coldash]<0
                ){
                    q.addLast(new Pair(rowdash,coldash));
                    matrix[rowdash][coldash]=matrix[rem.x][rem.y]+1;
                }

            }

        }
        return matrix;
    }

    static int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};


    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}

/*
3 3
0 0 0
0 1 1
1 1 1

 */
