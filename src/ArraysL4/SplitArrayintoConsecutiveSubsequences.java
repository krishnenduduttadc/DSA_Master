package ArraysL4;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 5};

        Map<Integer, Integer> f = new HashMap<>();
        Map<Integer, Integer> n = new HashMap<>();

        for (int x : a) f.put(x, f.getOrDefault(x, 0) + 1);

        for (int x : a) {
            if (f.get(x) == 0) continue;

            if (n.getOrDefault(x, 0) > 0) {
                n.put(x, n.get(x) - 1);
                n.put(x + 1, n.getOrDefault(x + 1, 0) + 1);
            } else if (f.getOrDefault(x + 1, 0) > 0 && f.getOrDefault(x + 2, 0) > 0) {
                f.put(x + 1, f.get(x + 1) - 1);
                f.put(x + 2, f.get(x + 2) - 1);
                n.put(x + 3, n.getOrDefault(x + 3, 0) + 1);
            } else {
                System.out.println(false);
                return;
            }
            f.put(x, f.get(x) - 1);
        }
        System.out.println(true);
    }
}
