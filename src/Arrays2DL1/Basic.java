package Arrays2DL1;

import java.util.Scanner;

public class Basic {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] arr=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=s.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}

/*
2
4
11
12
13
14
21
22
23
24
 */
