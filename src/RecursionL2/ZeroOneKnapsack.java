package RecursionL2;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] w = {1, 3, 4, 5};
        int[] v = {1, 4, 5, 7};
        System.out.println(f(0, w, v, 7));
    }

    static int f(int i, int[] w, int[] v, int cap) {
        if (i == w.length || cap == 0) return 0;
        int np = f(i + 1, w, v, cap);
        int p = 0;
        if (w[i] <= cap) {
            p = v[i] + f(i + 1, w, v, cap - w[i]);
        }
        return Math.max(p, np);
    }
}
