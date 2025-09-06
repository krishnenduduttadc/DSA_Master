package LeetCodePatterns.DP;

public class PalindromicSubstrings {
    // Main method to test the program
    public static void main(String[] args) {
        PalindromicSubstrings solver = new PalindromicSubstrings();

        String s1 = "abc";
        System.out.println("Number of palindromic substrings in \"" + s1 + "\": " + solver.countSubstrings(s1));

        String s2 = "aaa";
        System.out.println("Number of palindromic substrings in \"" + s2 + "\": " + solver.countSubstrings(s2));

        String s3 = "racecar";
        System.out.println("Number of palindromic substrings in \"" + s3 + "\": " + solver.countSubstrings(s3));
    }

    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // Single-character substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Two-character substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        // Substrings of length >= 3
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i + length - 1 < n; i++) {
                int start = i;
                int end = i + length - 1;

                dp[start][end] = dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
                if (dp[start][end]) {
                    count++;
                }
            }
        }

        return count;
    }
}
