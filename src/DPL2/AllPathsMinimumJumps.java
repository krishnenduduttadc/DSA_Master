/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;

import java.util.ArrayDeque;


public class AllPathsMinimumJumps {

    public static void main(String[] args) {
        int arr[] = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        solution(arr);
    }

    private static void solution(int[] arr) {
        Integer[] dp = new Integer[arr.length];
        dp[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < arr.length; j++) {
                if (dp[i + j] != null && dp[i + j] < min) {
                    min = dp[i + j];
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        System.out.println(dp[0]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, arr[0], dp[0], 0 + ""));
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if (rem.j == 0) {
                System.out.println(rem.psf + ".");
            }
            for (int j = 1; j <= rem.s && rem.i + j < arr.length; j++) {
                int ci = rem.i + j;
                if (dp[ci] != null && dp[ci] == rem.j - 1) {
                    queue.add(new Pair(ci, arr[ci], dp[ci], rem.psf + "->" + ci));
                }
            }
        }
    }

    public static class Pair {

        int i, s, j;
        String psf;

        Pair(int i, int s, int j, String psf) {
            this.i = i;
            this.s = s;
            this.j = j;
            this.psf = psf;
        }
    }
}
