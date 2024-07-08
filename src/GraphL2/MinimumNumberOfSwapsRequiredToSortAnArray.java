package GraphL2;

import java.util.Arrays;

public class MinimumNumberOfSwapsRequiredToSortAnArray {
    public static void main(String[] args) {
        int[] arr = {10, 19, 6, 3, 5};
        System.out.println(minSwaps(arr));
    }

    public static int minSwaps(int[] arr1) {
        int n = arr1.length;
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(arr1[i], i);
        }
        Arrays.sort(arr);
        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] || arr[i].idx == i) {
                continue;
            }

            int clen = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                clen++;
                j = arr[j].idx;
            }
            ans += (clen - 1);
        }
        return ans;
    }

    private static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}
