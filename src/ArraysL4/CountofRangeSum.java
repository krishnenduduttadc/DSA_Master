package ArraysL4;

import java.util.Arrays;

public class CountofRangeSum {
    static int c = 0;

    public static void main(String[] args) {
        int[] a = {-2, 5, -1};
        int l = -2, u = 2;
        long[] p = new long[a.length + 1];

        for (int i = 0; i < a.length; i++) p[i + 1] = p[i] + a[i];

        ms(p, 0, p.length, l, u);
        System.out.println(c);
    }

    static void ms(long[] p, int s, int e, int l, int u) {
        if (e - s <= 1) return;
        int m = (s + e) / 2;
        ms(p, s, m, l, u);
        ms(p, m, e, l, u);

        int i = s, j = m, k = m;
        while (i < m) {
            while (j < e && p[j] - p[i] < l) j++;
            while (k < e && p[k] - p[i] <= u) k++;
            c += k - j;
            i++;
        }

        Arrays.sort(p, s, e);
    }
}
