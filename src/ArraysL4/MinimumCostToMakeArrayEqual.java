package ArraysL4;

import java.util.Arrays;

public class MinimumCostToMakeArrayEqual {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2}, c = {2, 3, 1, 14};
        int n = a.length;

        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) p[i] = new int[]{a[i], c[i]};
        Arrays.sort(p, (x, y) -> x[0] - y[0]);

        long tot = 0;
        for (int[] x : p) tot += x[1];

        long s = 0, med = 0;
        for (int[] x : p) {
            s += x[1];
            if (s * 2 >= tot) {
                med = x[0];
                break;
            }
        }

        long r = 0;
        for (int i = 0; i < n; i++)
            r += 1L * Math.abs(a[i] - med) * c[i];

        System.out.println(r);
    }
}
