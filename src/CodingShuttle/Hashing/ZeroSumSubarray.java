package CodingShuttle.Hashing;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2, 2, -2, 2};
        System.out.println(countSubArraysWithZeroSum(a));
    }

    static int countSubArraysWithZeroSum(int[] a) {
        Set<Integer> set = new HashSet<>();
        int cs = 0;  // Current sum
        int count = 0;
        set.add(0);  // Initialize set with 0 to handle cases where subarray starts from index 0

        for (int e : a) {
            cs += e;  // Update the current sum

            if (set.contains(cs)) {  // If current sum already exists in set, we found a subarray with zero sum
                count++;
            } else {
                set.add(cs);  // Add the current sum to the set
            }
        }
        return count;  // Return the count of subarrays with zero sum
    }
}
