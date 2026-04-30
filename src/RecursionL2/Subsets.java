package RecursionL2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        f(0, a, new ArrayList<>());
    }

    static void f(int i, int[] a, List<Integer> t) {
        if (i == a.length) {
            System.out.print(t);
            return;
        }
        t.add(i + 1);
        f(i + 1, a, t);
        t.remove(t.size() - 1);
        f(i + 1, a, t);
    }
}
