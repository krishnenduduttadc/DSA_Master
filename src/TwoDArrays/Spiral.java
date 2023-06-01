package TwoDArrays;

import java.util.Scanner;

public class Spiral {
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

        int minr=0;
        int minc=0;
        int maxr=arr.length-1;
        int maxc=arr[0].length-1;
        int tne=n*m;
        int cnt=0;

        while(cnt<tne){
            for(int i=minr, j=minc;i<=maxr && cnt<tne;i++){
                System.out.println(arr[i][j]);
                cnt++;
            }
            minc++;

            for(int i=maxr,j=minc;j<=maxc && cnt<tne;j++){
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxr--;

            for(int i=maxr,j=maxc;i>=minr && cnt<tne;i--){
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxc--;



            for(int i=minr,j=maxc;j>=minc && cnt<tne;j--){
                System.out.println(arr[i][j]);
                cnt++;
            }
            minr++;


        }
    }
}

/*
3
5
11
12
13
14
15
21
22
23
24
25
31
32
33
34
35
 */
