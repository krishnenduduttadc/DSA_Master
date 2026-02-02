package CodingShuttle.DP;

import java.util.Arrays;

public class LCSTopUp {
    public static void main(String[] args) {
        String a = "ABCAB";
        String b = "AECB";

        System.out.println(lcs(a, b));
    }

    static int lcs(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        int ans = lcsUtil(a, b, a.length() - 1, b.length() - 1, dp);
        for (int[] x : dp) {
            for (int e : x) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        return ans;
    }

    static int lcsUtil(String a, String b, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = lcsUtil(a, b, i - 1, j - 1, dp) + 1;
        } else {
            dp[i][j] = Math.max(lcsUtil(a, b, i - 1, j, dp), lcsUtil(a, b, i, j - 1, dp));
            return dp[i][j];
        }
    }
}
