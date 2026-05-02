package ArraysL4;

import java.util.Arrays;

public class MaximumSumof3NonOverlappingSubarrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2, n = a.length;

        int[] s = new int[n - k + 1];
        for (int i = 0, sum = 0; i < n; i++) {
            sum += a[i];
            if (i >= k) sum -= a[i - k];
            if (i >= k - 1) s[i - k + 1] = sum;
        }

        int[] l = new int[s.length], r = new int[s.length];

        for (int i = 0, m = 0; i < s.length; i++) {
            if (s[i] > s[m]) m = i;
            l[i] = m;
        }

        for (int i = s.length - 1, m = s.length - 1; i >= 0; i--) {
            if (s[i] >= s[m]) m = i;
            r[i] = m;
        }

        int[] res = new int[3];
        int mx = 0;

        for (int i = k; i < s.length - k; i++) {
            int x = l[i - k], y = i, z = r[i + k];
            int sum = s[x] + s[y] + s[z];
            if (sum > mx) {
                mx = sum;
                res = new int[]{x, y, z};
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
