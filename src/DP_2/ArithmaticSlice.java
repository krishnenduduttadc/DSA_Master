package DP_2;

public class ArithmaticSlice {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 12, 15, 18, 22, 26, 30, 34, 36, 38, 40, 41};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;

        for (int i = 2; i < dp.length; i++) {
            if(arr[i]-arr[i-1] == arr[i-1]-arr[i-2]){
                dp[i]=dp[i-1]+1;
                ans+=dp[i];
            }
        }
        return ans;
    }
}
