package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AsFarFromLandAsPossible {
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

        System.out.println(maxDistance(arr));

    }
    public static class Pair{
        int row;
        int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }

    public static int maxDistance(int[][] grid) {
        //write your code here
        LinkedList<Pair> q=new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.addLast(new Pair(i,j));
                }
            }
        }

        if(q.size()==0 || q.size()==grid.length*grid[0].length){
            return -1;
        }
        int dirs[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int level=-1;
        while(q.size()>0){
            level++;
            int size=q.size();

            while(size-->0){
                Pair rem=q.removeFirst();
                for(int i=0;i<4;i++){
                    int rowdash=rem.row+dirs[i][0];
                    int coldash=rem.col+dirs[i][1];

                    if(rowdash<0 || coldash<0 || rowdash>=grid.length ||
                            coldash>=grid[0].length || grid[rowdash][coldash]==1){
                        continue;
                    }

                    q.addLast(new Pair(rowdash,coldash));
                    grid[rowdash][coldash]=1;
                }
            }
        }
        return level;

    }
}
/*
3
0 0 0
0 1 1
1 1 1

 */
