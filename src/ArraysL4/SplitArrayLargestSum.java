package ArraysL4;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] a = {7, 2, 5, 10, 8};
        int k = 2;

        int l = 0, h = 0;
        for (int x : a) {
            l = Math.max(l, x);
            h += x;
        }

        while (l < h) {
            int m = (l + h) / 2, c = 1, s = 0;
            for (int x : a) {
                if (s + x > m) {
                    c++;
                    s = 0;
                }
                s += x;
            }
            if (c > k) l = m + 1;
            else h = m;
        }
        System.out.println(l);
    }
}
