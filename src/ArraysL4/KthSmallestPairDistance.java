package ArraysL4;

import java.util.Arrays;

public class KthSmallestPairDistance {
    public static void main(String[] args) {
        int[] a = {1, 3, 1};
        int k = 1;

        Arrays.sort(a);
        int l = 0, h = a[a.length - 1] - a[0];

        while (l < h) {
            int m = (l + h) / 2, c = 0, j = 0;

            for (int i = 0; i < a.length; i++) {
                while (a[i] - a[j] > m) j++;
                c += i - j;
            }

            if (c < k) l = m + 1;
            else h = m;
        }
        System.out.println(l);
    }
}
