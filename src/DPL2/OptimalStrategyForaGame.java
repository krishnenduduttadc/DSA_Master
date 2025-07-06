package DPL2;

public class OptimalStrategyForaGame {
    public static void main(String[] args) {
        int[] arr = {20, 30, 2, 10};
        int n = arr.length;

        // dp[i][j] will store the maximum amount of money the player can collect from arr[i..j]
        int[][] dp = new int[n][n];

        // Fill the table diagonally
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {

                if (g == 0) {
                    // Only one coin, take it
                    dp[i][j] = arr[i];
                } else if (g == 1) {
                    // Two coins, take the maximum of the two
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    // Choose left coin (arr[i]) or right coin (arr[j])
                    // If choosing arr[i], opponent may choose from (i+1,j)
                    int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);

                    // If choosing arr[j], opponent may choose from (i,j-1)
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);

                    // Take the maximum of the two choices
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }

        System.out.println("Maximum value first player can collect: " + dp[0][n - 1]);
    }
}
