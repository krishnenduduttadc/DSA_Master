package HML2;

import java.util.Scanner;

public class MaximumConsecutiveOnes2 {
    public static int solution(int[] arr, int k){
        // write your code here
        int ans=0;
        int j=-1;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
            }

            while(count>k){
                j++;
                if(arr[j]==0){
                    count--;
                }
            }
            int len=i-j;
            if(len>ans){
                ans=len;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
    }
}

/*
6
1 1 0 0 1 1
1
 */
