package DP2;

public class LIS {
    public static void main(String[] args) {
        int[] arr={2,3,5,1,7};
        int[] dp=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
        }

        for (int i = 0; i <dp.length ; i++) {
            System.out.println(dp[i]);
        }
    }
}
