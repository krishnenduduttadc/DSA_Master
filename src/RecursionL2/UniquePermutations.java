package RecursionL2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniquePermutations {

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        f(a, 0);
    }

    static void f(int[] a, int i) {
        if (i == a.length) {
            System.out.println(Arrays.toString(a));
            return;
        }

        Set<Integer> s = new HashSet<>();
        for (int j = i; j < a.length; j++) {
            if (s.contains(a[j])) {
                continue;
            } else {
                s.add(a[j]);
            }
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            f(a, i + 1);
            t = a[j];
            a[j] = a[i];
            a[i] = t;
        }
    }
}
