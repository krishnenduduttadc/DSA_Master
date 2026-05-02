package ArraysL4;

public class NumberofSubarrayswithBoundedMaximum {
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3};
        int L = 2, R = 3;

        System.out.println(f(a, R) - f(a, L - 1));
    }

    static int f(int[] a, int x) {
        int r = 0, c = 0;
        for (int v : a) {
            if (v <= x) c++;
            else c = 0;
            r += c;
        }
        return r;
    }
}
