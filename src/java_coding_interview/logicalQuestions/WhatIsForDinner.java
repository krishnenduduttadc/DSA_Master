package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class WhatIsForDinner {
    public static void main(String[] args) {
        int n=4,m=3,k=18;
        int[][] input={{2,3},{1,2},{3,6},{2,5}};
        int[] arr=new int[m];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int[] in=input[i];
            int a=in[0];
            int b=in[1];
            arr[a-1]=Math.min(arr[a-1],b);
        }
        int s=0;
        for (int i = 0; i < m; i++) {
            s+=arr[i];
        }
        System.out.println(Math.min(s,k));
    }
}
