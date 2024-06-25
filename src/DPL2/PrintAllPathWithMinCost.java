package DPL2;

import java.util.ArrayDeque;

public class PrintAllPathWithMinCost {
    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        System.out.println(dp[0][0]);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair("", 0, 0));
        while (!q.isEmpty()) {
            Pair rem = q.removeFirst();
            if (rem.i == dp.length - 1 && rem.j == dp[0].length - 1) {
                System.out.println(rem.psf);
            } else if (rem.i == dp.length - 1) {
                q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
            } else if (rem.j == dp[0].length - 1) {
                q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
            } else {
                if (dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j]) {
                    q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                } else if (dp[rem.i][rem.j + 1] > dp[rem.i + 1][rem.j]) {
                    q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                } else {
                    q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                    q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                }
            }
        }
    }
}