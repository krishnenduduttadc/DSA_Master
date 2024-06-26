package DPL1;

public class TilingwithDominoe {
    public static void main(String[] args) throws Exception {

        int n = 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);

    }
}
