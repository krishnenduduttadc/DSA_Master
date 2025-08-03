package BinarySearchL1;

import java.util.Arrays;

public class AggressiveCows {

    public static int solve(int n, int k, int[] dist) {
        Arrays.sort(dist);
        int lo = dist[n - 1];
        for (int i = 1; i < n; i++) {
            lo = Math.min(lo, dist[i] - dist[i - 1]);
        }
        int hi = dist[n - 1] - dist[0];

        int ans = -1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;

            int cowsPlaced = count(dist, m);
            if (cowsPlaced >= k) {
                ans = m;
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return ans;

    }

    public static int count(int[] arr, int m) {
        int cows = 1;
        int lastcowPos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastcowPos >= m) {
                cows++;
                lastcowPos = arr[i];
            }
        }
        return cows;
    }


    public static void main(String[] args) {
        // Hardcoded input for testing
        int n = 5; // Number of stalls
        int k = 3; // Number of cows to place
        int[] dist = {1, 2, 4, 8, 9}; // Positions of the stalls
        int result = solve(n, k, dist);
        System.out.println("Maximum minimum distance to place " + k + " cows: " + result);
    }
}
