package RecursionL2;

public class MinimumSubsetDiff {

    public static void main(String[] args) {
        int[] a = {1, 6, 11, 5};
        int tot = 0;
        for (int x : a) tot += x;
        System.out.println(f(0, a, 0, tot));
    }

    static int f(int i, int[] a, int s, int tot) {
        if (i == a.length) {
            return Math.abs((tot - s) - s);
        }
        int p = f(i + 1, a, s + a[i], tot);
        int np = f(i + 1, a, s, tot);
        return Math.min(p, np);
    }
}
