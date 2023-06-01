package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfEnclaves {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(numEnclaves(arr));

    }

    public static int numEnclaves(int[][] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==0 || j==0 || i==arr.length-1 || j==arr[0].length-1){
                    if(arr[i][j]==1){
                        dfs(arr,i,j);
                    }
                }
            }
        }

        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int[][] arr,int i,int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length|| arr[i][j]==0){
            return;
        }
        arr[i][j]=0;
        dfs(arr,i+1,j);
        dfs(arr,i-1,j);
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);

    }
}

/*
4 4
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
 */
