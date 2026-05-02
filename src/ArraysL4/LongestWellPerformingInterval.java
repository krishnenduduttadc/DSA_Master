package ArraysL4;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        int[] a = {9, 9, 6, 0, 6, 6, 9};
        int s = 0, r = 0;

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            s += a[i] > 8 ? 1 : -1;

            if (s > 0) r = i + 1;
            else {
                m.putIfAbsent(s, i);
                if (m.containsKey(s - 1))
                    r = Math.max(r, i - m.get(s - 1));
            }
        }
        System.out.println(r);
    }
}
