package ArraysL4;

import java.util.HashMap;
import java.util.Map;

public class SubarraywithKdistinctIntegers {

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(f(a, k) - f(a, k - 1));
    }

    static int f(int[] a, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < a.length; r++) {
            m.put(a[r], m.getOrDefault(a[r], 0) + 1);

            while (m.size() > k) {
                m.put(a[l], m.get(a[l]) - 1);
                if (m.get(a[l]) == 0) m.remove(a[l]);
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
