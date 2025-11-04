package DP_Patterns;

public class DPPatterns {


    public static void main(String[] args) {
        fibonacciDemo();
        minCost1DDemo();
        kadaneDemo();
        knapsack01Demo();
        coinChangeDemo();
        lisDemo();
        lcsDemo();
        editDistanceDemo();
        matrixMinPathDemo();
        uniquePathsDemo();
        palindromicSubseqDemo();
        palindromicSubstringDemo();
        partitionDPMatrixChainDemo();
        intervalMergeStonesDemo();
        stockOneTransactionDemo();
        stockKTransactionsDemo();
        bitmaskTSPDemo();
        countSubsequencesDemo();
        treeDPSubtreeSumDemo();
        wordBreakDemo();
        probabilityDiceSumDemo();
        gameTheoryPredictWinnerDemo();
    }

    // 1. Fibonacci / counting ways (1D additive)
    static void fibonacciDemo() {
        int n = 10;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        System.out.println("Fibonacci(10): " + dp[n]);
    }

    // 2. Min cost 1D (minimization)
    static void minCost1DDemo() {
// cost to step i (example), min cost to reach each step from 0
        int[] cost = {0, 5, 3, 4, 2}; // cost[0] unused or start cost
        int n = cost.length - 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        System.out.println("Min cost to reach end (1D): " + dp[n]);
    }

    // 3. Kadane (max subarray)
    static void kadaneDemo() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        int best = a[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(a[i], dp[i - 1] + a[i]);
            best = Math.max(best, dp[i]);
        }
        System.out.println("Max subarray sum (Kadane): " + best);
    }

    // 4. 0/1 Knapsack (2D DP)
    static void knapsack01Demo() {
        int[] wt = {1, 3, 4};
        int[] val = {15, 20, 30};
        int W = 4;
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];
                if (w >= wt[i - 1]) dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
            }
        }
        System.out.println("0/1 Knapsack max value: " + dp[n][W]);
    }

    // 5. Coin change (count ways and min coins)
    static void coinChangeDemo() {
        int[] coins = {1, 2, 5};
        int amount = 5;
// count ways (combinations)
        long[] ways = new long[amount + 1];
        ways[0] = 1;
        for (int c : coins) {
            for (int a = c; a <= amount; a++) ways[a] += ways[a - c];
        }
// min coins
        int INF = 1_000_000;
        int[] minCoins = new int[amount + 1];
        for (int i = 1; i <= amount; i++) minCoins[i] = INF;
        for (int c : coins) {
            for (int a = c; a <= amount; a++) minCoins[a] = Math.min(minCoins[a], minCoins[a - c] + 1);
        }
        System.out.println("Coin change ways to make 5: " + ways[amount] + ", minCoins: " + (minCoins[amount] >= INF ? -1 : minCoins[amount]));
    }

    // 6. LIS (O(n^2) DP)
    static void lisDemo() {
        int[] a = {3, 1, 5, 2, 6, 4, 9};
        int n = a.length;
        int[] dp = new int[n];
        int best = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) if (a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            best = Math.max(best, dp[i]);
        }
        System.out.println("LIS length: " + best);
    }

    // 7. LCS (2D DP)
    static void lcsDemo() {
        String A = "AGGTAB";
        String B = "GXTXAYB";
        int n = A.length(), m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println("LCS length: " + dp[n][m]);
    }

    // 8. Edit Distance (Levenshtein)
    static void editDistanceDemo() {
        String s1 = "kitten", s2 = "sitting";
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        System.out.println("Edit distance (kitten -> sitting): " + dp[n][m]);
    }

    // 9. Matrix minimum path sum (grid)
    static void matrixMinPathDemo() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int j = 1; j < m; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        System.out.println("Min path sum grid: " + dp[n - 1][m - 1]);
    }

    // 10. Unique paths (grid)
    static void uniquePathsDemo() {
        int n = 3, m = 3;
        long[][] dp = new long[n][m];
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        for (int j = 0; j < m; j++) dp[0][j] = 1;
        for (int i = 1; i < n; i++) for (int j = 1; j < m; j++) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        System.out.println("Unique paths 3x3: " + dp[n - 1][m - 1]);
    }

    // 11. Palindromic subsequence (longest)
    static void palindromicSubseqDemo() {
        String s = "bbbab";
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + (j - 1 >= i + 1 ? dp[i + 1][j - 1] : 0);
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        System.out.println("Longest palindromic subsequence length: " + dp[0][n - 1]);
    }

    // 12. Palindromic substring boolean table (is substring palindrome)
    static void palindromicSubstringDemo() {
        String s = "babad";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int bestLen = 1;
        String best = s.substring(0, 1);
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (len > bestLen) {
                        bestLen = len;
                        best = s.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println("Longest palindromic substring (one): " + best + " len=" + bestLen);
    }

    // 13. Partition DP: Matrix chain multiplication (min multiplications)
    static void partitionDPMatrixChainDemo() {
// chain: matrices A1(10x30), A2(30x5), A3(5x60)
        int[] dims = {10, 30, 5, 60}; // length k+1 for k matrices
        int k = dims.length - 1;
        long[][] dp = new long[k + 1][k + 1];
        for (int len = 2; len <= k; len++) {
            for (int i = 1; i + len - 1 <= k; i++) {
                int j = i + len - 1;
                dp[i][j] = Long.MAX_VALUE / 4;
                for (int r = i; r < j; r++) {
                    long cost = dp[i][r] + dp[r + 1][j] + (long) dims[i - 1] * dims[r] * dims[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        System.out.println("Matrix chain min multiplications: " + dp[1][k]);
    }

    // 14. Interval DP example: Merge stones (simple)
    static void intervalMergeStonesDemo() {
        int[] stones = {3, 2, 4};
        int n = stones.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE / 4;
                int sum = 0;
                for (int x = i; x <= j; x++) sum += stones[x];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        System.out.println("Merge stones min cost: " + dp[0][n - 1]);
    }

    // 15. Stock buy/sell one transaction
    static void stockOneTransactionDemo() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            best = Math.max(best, p - minPrice);
        }
        System.out.println("Max profit one transaction: " + best);
    }

    // 16. Stock k transactions (simple DP)
    static void stockKTransactionsDemo() {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int K = 2;
        int n = prices.length;
        if (n == 0) {
            System.out.println("Stock K: 0");
            return;
        }
        int[][] dp = new int[K + 1][n];
        for (int k = 1; k <= K; k++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - prices[i]);
            }
        }
        System.out.println("Max profit with K=2: " + dp[K][n - 1]);
    }

    // 17. Bitmask DP - small TSP 4 nodes (held-karp)
    static void bitmaskTSPDemo() {
        int N = 4;
        int[][] dist = {
                {0, 1, 15, 6},
                {2, 0, 7, 3},
                {9, 6, 0, 12},
                {10, 4, 8, 0}
        };
        int FULL = (1 << N);
        int[][] dp = new int[FULL][N];
        for (int mask = 0; mask < FULL; mask++) for (int i = 0; i < N; i++) dp[mask][i] = Integer.MAX_VALUE / 4;
        dp[1 << 0][0] = 0; // start at 0
        for (int mask = 0; mask < FULL; mask++) {
            for (int u = 0; u < N; u++) {
                if ((mask & (1 << u)) == 0) continue;
                for (int v = 0; v < N; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    int nmask = mask | (1 << v);
                    dp[nmask][v] = Math.min(dp[nmask][v], dp[mask][u] + dist[u][v]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) ans = Math.min(ans, dp[FULL - 1][i] + dist[i][0]);
        System.out.println("TSP (Held-Karp) approx min cost: " + ans);
    }

    // 18. Count subsequences (pattern matching)
    static void countSubsequencesDemo() {
        String s = "rabbbit", t = "rabbit"; // example -> 3 ways
        int n = s.length(), m = t.length();
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println("Count subsequences (rabbbit -> rabbit): " + dp[n][m]);
    }

    static int treeDPSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        int left = treeDPSubtreeSum(node.left);
        int right = treeDPSubtreeSum(node.right);
        int sum = node.val + left + right;
// store/print the dp for node (postorder)
        System.out.println("subtree sum at node " + node.val + " = " + sum);
        return sum;
    }

    static void treeDPSubtreeSumDemo() {
// small tree: 1
// /
// 2 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Tree DP - subtree sums:");
        treeDPSubtreeSum(root);
    }

    // 20. Word Break (1D)
    static void wordBreakDemo() {
        String s = "leetcode";
        java.util.Set<String> dict = new java.util.HashSet<>();
        dict.add("leet");
        dict.add("code");
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println("WordBreak (leetcode): " + dp[n]);
    }

    // 21. Probability DP: dice sum distribution (example: 2 dice sum probability)
    static void probabilityDiceSumDemo() {
        int dice = 2, faces = 6;
        int maxSum = dice * faces;
        double[][] dp = new double[dice + 1][maxSum + 1];
        dp[0][0] = 1.0;
        for (int d = 1; d <= dice; d++) {
            for (int sum = d; sum <= d * faces; sum++) {
                double acc = 0;
                for (int f = 1; f <= faces && f <= sum; f++) acc += dp[d - 1][sum - f];
                dp[d][sum] = acc / faces;
            }
        }
        System.out.println("Probability sum 7 with 2 dice: " + dp[dice][7]);
    }

    // 22. Game theory DP - Predict the Winner (net advantage)
    static void gameTheoryPredictWinnerDemo() {
        int[] nums = {1, 5, 2};
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        int net = dp[0][n - 1];
        System.out.println("Game theory net advantage (player1 - player2): " + net + " => player1 wins? " + (net >= 0));
    }

    // 19. DP on trees (subtree sum) - postorder
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }
}

