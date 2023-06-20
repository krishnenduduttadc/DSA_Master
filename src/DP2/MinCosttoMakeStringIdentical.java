package DP2;

public class MinCosttoMakeStringIdentical {
    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "cut";
        int c1 = 1;
        int c2 = 1;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length-1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else if (i == dp.length - 1) {
                    dp[i][j] = 0;
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }

                }
            }
        }


        int lcs=dp[0][0];
        System.out.println(lcs);
        int s1r=s1.length()-lcs;
        int s2r=s2.length()-lcs;
        int cost=s1r*c1+s2r*c2;
        System.out.println(cost);
    }

}
