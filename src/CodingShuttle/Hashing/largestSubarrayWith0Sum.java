package CodingShuttle.Hashing;

import java.util.HashMap;
import java.util.Map;

public class largestSubarrayWith0Sum {
    public static void main(String[] args) {
        int[] a = {15, -2, 2, -8, 1, 7, 10};
        System.out.println(largestZeroSumSubArray(a));
    }

    static int largestZeroSumSubArray(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int cs = 0;
        int maxLength = 0;
        map.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            cs += a[i];
            if (map.containsKey(cs)) {
                maxLength = Math.max(i - map.get(cs), maxLength);
            } else {
                map.put(cs, i);
            }
        }
        return maxLength;
    }
}
