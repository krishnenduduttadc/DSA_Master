package CodingShuttle.Hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2, -2, 2};
        int sum = 0;
        System.out.println(countSubArrayWithGivenSum(a, 0));
    }

    static int countSubArrayWithGivenSum(int[] a, int k) {
        Set<Integer> set = new HashSet<>();
        int cs = 0;
        int count = 0;
        set.add(0);
        for (int e : a) {
            cs += e;
            if (set.contains(cs - k)) {
                count++;
            } else {
                set.add(cs);
            }
        }
        return count;
    }
}
