package DPL2;

import java.util.ArrayDeque;


public class PrintPathMaxGold {

    public static void main(String[] args) {
        int arr[][] = {
                {3, 2, 3, 1},
                {2, 4, 6, 0},
                {5, 0, 1, 3},
                {9, 1, 5, 1}
        };

        int[][] dp = new int[arr.length][arr[0].length];

        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < arr.length; i++) {
                if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == arr.length - 1) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        System.out.println("" + max);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > max) {
                q.add(new Pair(i + "", i, 0));
            }
        }

        while (q.size() > 0) {
            Pair rem = q.removeFirst();
            if (rem.j == arr[0].length - 1) {
                System.out.println(rem.psf);
            } else if (rem.i == 0) {
                int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]);
                if (g == dp[rem.i][rem.j + 1]) {
                    q.add(new Pair(rem.psf + "d2", rem.i, rem.j + 1));
                }
                if (g == dp[rem.i + 1][rem.j + 1]) {
                    q.add(new Pair(rem.psf + "d3", rem.i + 1, rem.j + 1));
                }
            } else if (rem.i == arr.length - 1) {

                int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]);
                if (g == dp[rem.i][rem.j + 1]) {
                    q.add(new Pair(rem.psf + "d2", rem.i, rem.j + 1));
                }
                if (g == dp[rem.i - 1][rem.j + 1]) {
                    q.add(new Pair(rem.psf + "d1", rem.i - 1, rem.j + 1));
                }

            } else {
                int g = Math.max(dp[rem.i][rem.j + 1], Math.max(dp[rem.i - 1][rem.j + 1], dp[rem.i + 1][rem.j + 1]));
                if (g == dp[rem.i - 1][rem.j + 1]) {
                    q.add(new Pair(rem.psf + "d1", rem.i - 1, rem.j + 1));
                }
                if (g == dp[rem.i][rem.j + 1]) {
                    q.add(new Pair(rem.psf + "d2", rem.i, rem.j + 1));
                }
                if (g == dp[rem.i + 1][rem.j + 1]) {
                    q.add(new Pair(rem.psf + "d3", rem.i + 1, rem.j + 1));
                }

            }
        }

    }

    public static class Pair {

        int j, i;
        String psf;

        Pair(String psf, int i, int j) {
            this.j = j;
            this.i = i;
            this.psf = psf;
        }
    }
}
