package RecursionL2;

import java.util.ArrayList;
import java.util.List;

public class Subseq {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        f(0, a, new ArrayList<>());
    }

    static void f(int i, int[] a, List<Integer> l) {
        if (i == a.length) {
            System.out.println(l);
            return;
        }

        l.add(a[i]);
        f(i + 1, a, l);

        l.remove(l.size() - 1);
        f(i + 1, a, l);
    }
}
