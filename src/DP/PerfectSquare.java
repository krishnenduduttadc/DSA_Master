package DP;

public class PerfectSquare {
    public static void main(String[] args) {
        int[] arr={0,1,2,3,1,2,3,4,2,1,2,3};
        int[] dp=new int[arr.length+1];

        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i <=arr.length; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 1; j*j <=i ; j++) {
                int rem=i-j*j;
                if(dp[rem]<min){
                    min=dp[rem];
                }
            }
            dp[i]=min+1;
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }

    }
}
