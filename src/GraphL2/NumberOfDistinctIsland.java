package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class NumberOfDistinctIsland {
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

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder();

    static void dfs(int[][] arr,int row,int col){
        arr[row][col]=0;
        if(row-1>=0 && arr[row-1][col]==1){
            psf.append("u");
            dfs(arr,row-1,col);
        }
        if(col+1<arr[0].length && arr[row][col+1]==1){
            psf.append("r");
            dfs(arr,row,col+1);
        }
        if(row+1<arr.length && arr[row+1][col]==1){
            psf.append("d");
            dfs(arr,row+1,col);
        }
        if(col-1>=0 && arr[row][col-1]==1){
            psf.append("l");
            dfs(arr,row,col-1);
        }
        psf.append("a");
    }

    public static int numDistinctIslands(int[][] arr) {
        //write your code here
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    psf=new StringBuilder();
                    psf.append("x");
                    dfs(arr,i,j);
                    set.add(psf.toString());
                }
            }
        }
        return set.size();

    }
}

/*
3 3
1 0 0
0 1 0
1 1 1

 */
