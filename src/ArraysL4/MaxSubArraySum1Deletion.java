package ArraysL4;

public class MaxSubArraySum1Deletion {
    public static void main(String[] args) throws java.lang.Exception {
        int[] a = {1, -2, 0, 3};
        int n = a.length, f = a[0], g = 0, r = a[0];
        for (int i = 1; i < n; i++) {
            g = Math.max(g + a[i], f);
            f = Math.max(a[i], f + a[i]);
            r = Math.max(r, Math.max(f, g));
        }
        System.out.println(r);
    }
}
