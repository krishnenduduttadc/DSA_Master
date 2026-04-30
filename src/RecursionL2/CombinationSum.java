package RecursionL2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static void f(int i, int[] a, int t, List<Integer> l) {
        if (t == 0) {
            System.out.println(l);
            return;
        }

        for (int j = i; j < a.length; j++) {
            if (a[j] > t) continue;

            l.add(a[j]);
            f(j, a, t - a[j], l);   // notice j (not j+1)
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        f(0, a, 7, new ArrayList<>());
    }
}
