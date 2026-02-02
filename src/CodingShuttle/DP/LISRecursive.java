package CodingShuttle.DP;

import java.util.Arrays;

public class LISRecursive {
    static int ANS = 0;

    public static void main(String[] args) {
        int[] a = {2, 1, 40, 0, 1, 10};
        System.out.println(lis(a));
    }

    static int lis(int[] a) {
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        lisUtil(a, a.length - 1, dp);
        return ANS;
    }

    static int lisUtil(int[] a, int ind, int[] dp) {
        if (ind == 0) return 1;

        if (dp[ind] != -1) return dp[ind];

        int max = 1;
        for (int i = 0; i < ind; i++) {
            int lisAtI = lisUtil(a, i, dp);
            if (a[i] < a[ind]) {
                max = Math.max(lisAtI + 1, max);
            }
        }

        ANS = Math.max(ANS, max);
        return dp[ind] = max;
    }
}
