package LeetCodePatterns.DP;

public class LongestPalindromicSubstring {
    // Main method to test the program
    public static void main(String[] args) {
        LongestPalindromicSubstring solver = new LongestPalindromicSubstring();

        String s1 = "babad";
        System.out.println("Longest palindrome in \"" + s1 + "\": " + solver.longestPalindrome(s1));

        String s2 = "cbbd";
        System.out.println("Longest palindrome in \"" + s2 + "\": " + solver.longestPalindrome(s2));

        String s3 = "a";
        System.out.println("Longest palindrome in \"" + s3 + "\": " + solver.longestPalindrome(s3));

        String s4 = "ac";
        System.out.println("Longest palindrome in \"" + s4 + "\": " + solver.longestPalindrome(s4));
    }

    public String longestPalindrome(String s) {
        int n = s.length();

        String ans = "";
        boolean[][] dp = new boolean[n][n];

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans = s.substring(i, i + 1);
        }

        // Check for substring of length 2
        for (int i = 0; i + 1 < n; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans = s.substring(i, i + 2);
            }
        }

        // Check for substring of length >= 3
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                int end = start + length - 1;
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    ans = s.substring(start, end + 1);
                }
            }
        }

        return ans;
    }
}
