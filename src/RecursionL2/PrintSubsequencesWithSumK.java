package RecursionL2;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWithSumK {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        f(0, a, 0, 9, new ArrayList<>());
    }

    static void f(int i, int[] a, int s, int k, List<Integer> l) {
        if (i == a.length) {
            if (s == k) {
                System.out.println(l);
            }
            return;
        }
        l.add(a[i]);
        f(i + 1, a, s + a[i], k, l);

        l.remove(l.size() - 1);
        f(i + 1, a, s, k, l);
    }
}
