package CodingShuttle.Hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] a = {1, 3, 3, 11, 2, 2};
        int x = 5;
        int[] ans = twoSumUsingMap(a, x);
        System.out.println(ans[0] + " " + ans[1]);
    }

    static int[] twoSumUsingMap(int[] a, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = {-1, -1};
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(x - a[i])) {
                ans[0] = map.get(x - a[i]);
                ans[1] = i;
                return ans;
            } else {
                map.putIfAbsent(a[i], i);
            }
        }
        return ans;
    }
}
