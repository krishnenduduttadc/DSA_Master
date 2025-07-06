package DPL2;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "cut";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Initialize base cases
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i; // i deletions
        }

        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j; // j insertions
        }

        // Fill the DP table
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed
                } else {
                    int replace = 1 + dp[i - 1][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int insert = 1 + dp[i][j - 1];
                    dp[i][j] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }

        // Print the result (minimum edit distance)
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
