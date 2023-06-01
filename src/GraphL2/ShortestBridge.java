package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ShortestBridge {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(shortestBridge(arr));

    }

    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }


    public static int shortestBridge(int[][] A) {
        LinkedList<Pair> q=new LinkedList<>();
        boolean[][] visited=new boolean[A.length][A[0].length];
        boolean flag=false;


        for(int i=0;i<A.length && !flag;i++){
            for(int j=0;j<A[0].length && !flag;j++){
                if(A[i][j]==1){
                    dfs(i,j,A,q,visited);
                    flag=true;
                }
            }
        }

        int level=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                Pair rem=q.removeFirst();
                for(int i=0;i<4;i++){
                    int rowdash=rem.row+dirs[i][0];
                    int coldash=rem.col+dirs[i][1];

                    if(rowdash<0 || coldash<0 || coldash>=A[0].length || rowdash>=A.length||
                            visited[rowdash][coldash]==true){
                        continue;
                    }

                    if(A[rowdash][coldash]==1){
                        return level;
                    }

                    q.addLast(new Pair(rowdash,coldash));
                }
            }
            level++;
        }
        return -1;
    }


    static int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};

    static void dfs(int i, int j, int[][] A, LinkedList<Pair> q, boolean[][] vis){
        vis[i][j]=true;
        q.addLast(new Pair(i,j));
        for(int k=0;k<4;k++){
            int rowdash=i+dirs[k][0];
            int coldash=j+dirs[k][1];

            if(rowdash<0 || coldash<0 || coldash>=A[0].length || rowdash>=A.length||
                    vis[rowdash][coldash]==true|| A[rowdash][coldash]==0){
                continue;
            }

            dfs(rowdash,coldash,A,q,vis);
        }
    }
}

/*
3
0 1 0
0 0 0
1 1 1

 */
