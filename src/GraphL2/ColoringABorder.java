package GraphL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColoringABorder {
    public static void coloring_border(int [][] grid, int row, int col , int color){
        dfs(grid,row,col,grid[row][col]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]<0){
                    grid[i][j]=color;
                }
            }
        }

    }
    static int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public static void dfs(int [][] grid,int row,int col,int clr){
        grid[row][col]=-clr;
        int count=0;

        for(int i=0;i<4;i++){
            int rowdash=row+dirs[i][0];
            int coldash=col+dirs[i][1];
            if(rowdash<0 || coldash<0 || rowdash>=grid.length
                    ||coldash>=grid[0].length || Math.abs(grid[rowdash][coldash])!=clr ){
                continue;
            }

            count++;
            if(grid[rowdash][coldash]==clr){
                dfs(grid,rowdash,coldash,clr);
            }
        }

        if(count==4){
            grid[row][col]=clr;
        }
    }


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
        st = br.readLine().split(" ");
        int row = Integer.parseInt(st[0]);
        int col = Integer.parseInt(st[1]);
        int color = Integer.parseInt(st[2]);



        coloring_border(arr,row,col,color);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}

/*
4 4
2 1 3 4
1 2 2 2
3 2 2 2
1 2 2 2
1 1 3
 */
