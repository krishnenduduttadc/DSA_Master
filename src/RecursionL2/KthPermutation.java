package RecursionL2;

import java.util.Arrays;

public class KthPermutation {

    static int c = 0;

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        f(a, 0, 4);
    }

    static void f(int[] a, int i, int k) {
        if (i == a.length) {
            c++;
            if (c == k) {
                System.out.println(Arrays.toString(a));
            }
            return;
        }

        for (int j = i; j < a.length; j++) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            f(a, i + 1, k);
            t = a[i];
            a[i] = a[j];
            a[j] = t;

        }
    }
}
