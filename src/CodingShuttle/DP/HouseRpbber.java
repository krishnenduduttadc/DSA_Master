package CodingShuttle.DP;

import java.util.Arrays;

public class HouseRpbber {
    public static void main(String[] args) {
        int[] a = {5, 3, 4, 11, 2};
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        System.out.println(robbingHouse(a, a.length - 1, dp));
        System.out.println(robbingHouseBottomUp(a));
    }

    static int robbingHouse(int[] a, int i, int[] dp) {
        if (i < 0) return 0;
        if (i == 0) return a[0];

        if (dp[i] != -1) return dp[i];

        return dp[i] = Math.max(a[i] + robbingHouse(a, i - 2, dp),
                robbingHouse(a, i - 1, dp));
    }

    static int robbingHouseBottomUp(int[] a) {
        int first = 0;
        int second = a[0];

        for (int i = 1; i < a.length; i++) {
            int ans = Math.max(a[i] + first, second);
            first = second;
            second = ans;
        }

        return second;
    }
}
