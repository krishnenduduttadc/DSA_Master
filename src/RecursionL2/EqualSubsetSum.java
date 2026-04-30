package RecursionL2;

public class EqualSubsetSum {

    public static void main(String[] args) {
        int[] a = {1, 5, 11, 5};
        int sum = 0;
        for (int x : a) sum += x;
        System.out.println(sum);

        if (sum % 2 == 1) System.out.println(false);
        else System.out.println(f(0, a, sum / 2));
    }


    static boolean f(int i, int[] a, int s) {
        if (s == 0) {
            return true;
        }
        if (i == a.length || s < 0) return false;

        return f(i + 1, a, s - a[i]) || f(i + 1, a, s);
    }
}
