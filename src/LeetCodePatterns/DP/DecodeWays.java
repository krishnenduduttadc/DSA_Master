package LeetCodePatterns.DP;

public class DecodeWays {

    // Main method to test the program
    public static void main(String[] args) {
        DecodeWays solver = new DecodeWays();

        String s1 = "12";
        System.out.println("Number of decodings for \"" + s1 + "\": " + solver.numDecodings(s1));

        String s2 = "226";
        System.out.println("Number of decodings for \"" + s2 + "\": " + solver.numDecodings(s2));

        String s3 = "06";
        System.out.println("Number of decodings for \"" + s3 + "\": " + solver.numDecodings(s3));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int singleDigit = Integer.parseInt(s.substring(i - 1, i));
            int doubleDigit = Integer.parseInt(s.substring(i - 2, i));

            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
