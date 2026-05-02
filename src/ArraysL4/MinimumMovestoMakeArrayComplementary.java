package ArraysL4;

public class MinimumMovestoMakeArrayComplementary {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3};
        int lim = 4, n = a.length;

        int[] d = new int[2 * lim + 2];

        for (int i = 0; i < n / 2; i++) {
            int x = a[i], y = a[n - 1 - i];
            int l = 1 + Math.min(x, y), r = lim + Math.max(x, y), s = x + y;

            d[2] += 2;
            d[l]--;
            d[s]--;
            d[s + 1]++;
            d[r + 1]++;
        }

        int r = Integer.MAX_VALUE, c = 0;
        for (int i = 2; i <= 2 * lim; i++) {
            c += d[i];
            r = Math.min(r, c);
        }
        System.out.println(r);
    }
}
