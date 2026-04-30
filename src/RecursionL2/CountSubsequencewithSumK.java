package RecursionL2;

public class CountSubsequencewithSumK {

    static int f(int i, int[] a, int s, int k) {
        if (i == a.length) {
            if (s == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int n = f(i + 1, a, s + a[i], k);
        int np = f(i + 1, a, s, k);
        return n + np;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1};
        System.out.println(f(0, a, 0, 2));
    }
}
