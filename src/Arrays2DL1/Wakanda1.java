package Arrays2DL1;

import java.util.Scanner;

public class Wakanda1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] arr=new int[n][m];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=s.nextInt();
            }
        }

        for(int j=0;j<m;j++){
            if(j%2==0){
                for(int i=0;i<n;i++){
                    System.out.println(arr[i][j]);
                }

            }else{
                for(int i=arr.length-1;i>=0;i--){
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}

/*
3
4
11
12
13
14
21
22
23
24
31
32
33
34
 */
