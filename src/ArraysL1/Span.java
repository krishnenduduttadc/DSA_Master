package ArraysL1;

import java.util.Scanner;

public class Span {
    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        System.out.println(max-min);
    }
}

/*
6
15
30
40
4
11
9
 */
