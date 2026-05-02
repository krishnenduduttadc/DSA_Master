package ArraysL4;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayswithMedianK {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 4, 5};
        int k = 4, n = a.length;

        int i = 0;
        for (; i < n; i++) if (a[i] == k) break;

        Map<Integer, Integer> m = new HashMap<>();
        int s = 0;
        m.put(0, 1);

        for (int j = i - 1; j >= 0; j--) {
            s += a[j] < k ? -1 : 1;
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        int r = 0;
        s = 0;
        for (int j = i; j < n; j++) {
            s += a[j] < k ? -1 : a[j] > k ? 1 : 0;
            r += m.getOrDefault(-s, 0) + m.getOrDefault(1 - s, 0);
        }

        System.out.println(r);
    }
}
