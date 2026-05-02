package ArraysL4;

public class FirstMissingPositive {
    public static void main(String[] args) throws java.lang.Exception {
        int[] a = {3, 4, -1, 1};
        int n = a.length;

        for (int i = 0; i < n; i++)
            while (a[i] > 0 && a[i] <= n && a[a[i] - 1] != a[i]) {
                int t = a[i];
                a[i] = a[t - 1];
                a[t - 1] = t;
            }

        int i = 0;
        for (; i < n; i++) if (a[i] != i + 1) break;

        System.out.println(i + 1);
    }
}
