package DPL1;

import java.util.Arrays;

public class LCS3strings {
    public static void main(String[] args) {
        LCS3strings solution = new LCS3strings();

        // Test case
        String A = "geeks";
        String B = "geeksfor";
        String C = "geeksforgeeks";
        int n1 = A.length();
        int n2 = B.length();
        int n3 = C.length();

        int result = solution.LCSof3(A, B, C, n1, n2, n3);

        System.out.println("Length of LCS of (" + A + ", " + B + ", " + C + ") is: " + result);
    }

    int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1][n2][n3];
        for (int[][] dd : dp) {
            for (int[] d : dd) {
                Arrays.fill(d, -1);
            }
        }
        return LCS(A, n1 - 1, B, n2 - 1, C, n3 - 1, dp);
    }

    public int LCS(String s1, int i, String s2, int j, String s3, int k, int[][][] dp) {
        if (i == -1 || j == -1 || k == -1)
            return 0;

        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        if (s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
            int x = LCS(s1, i - 1, s2, j - 1, s3, k - 1, dp);
            dp[i][j][k] = x + 1;
            return dp[i][j][k];
        } else {
            int x = LCS(s1, i - 1, s2, j, s3, k, dp);
            int y = LCS(s1, i, s2, j - 1, s3, k, dp);
            int z = LCS(s1, i, s2, j, s3, k - 1, dp);
            dp[i][j][k] = Math.max(Math.max(x, y), z);
            return dp[i][j][k];
        }
    }
}
