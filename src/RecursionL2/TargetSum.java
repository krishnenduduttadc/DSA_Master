package RecursionL2;

public class TargetSum {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        System.out.println(f(0, a, 0, 3));
    }

    static int f(int i, int[] a, int s, int t) {
        if (i == a.length) {
            return s == t ? 1 : 0;
        }
        int p = f(i + 1, a, s + a[i], t);
        int np = f(i + 1, a, s - a[i], t);
        return p + np;
    }
}
