package RecursionL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumWithoutDuplicate {
    static void f(int i, int[] a, int t, List<Integer> l) {
        if (t == 0) {
            System.out.println(l);
            return;
        }

        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j - 1]) continue;
            if (a[j] > t) break;

            l.add(a[j]);
            f(j + 1, a, t - a[j], l);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 5, 6, 7, 10};
        Arrays.sort(a);
        f(0, a, 8, new ArrayList<>());
    }
}
