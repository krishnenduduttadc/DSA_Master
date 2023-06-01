package GraphL2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SwimInRisingWaterHard {
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int msf;

        Pair(int row,int col,int msf){
            this.row=row;
            this.col=col;
            this.msf=msf;
        }

        @Override
        public int compareTo(Pair o){
            return this.msf-o.msf;
        }

    }

    public static int swimInRisingWater(int [][]grid)
    {
        int n=grid.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        boolean[][] vis=new boolean[n][n];
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};

        while(pq.size()>0){
            Pair rem=pq.remove();
            if(rem.row==n-1 && rem.col==n-1){
                return rem.msf;
            }

            if(vis[rem.row][rem.col]==true){
                continue;
            }

            vis[rem.row][rem.col]=true;

            for(int i=0;i<4;i++){
                int rowdash=rem.row+dirs[i][0];
                int coldash=rem.col+dirs[i][1];

                if(rowdash<0 || coldash<0 || rowdash>=n || coldash>=n ||
                        vis[rowdash][coldash]==true){
                    continue;
                }

                pq.add(new Pair(rowdash,coldash,Math.max(rem.msf,grid[rowdash][coldash])));
            }
        }
        return 0;

    }

    public static void main(String[] args)  {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int [][]grid=new int [n][m];
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j) grid[i][j]=scn.nextInt();
        System.out.println(swimInRisingWater(grid));

    }
}

/*
2
2
0 2
1 3
 */
