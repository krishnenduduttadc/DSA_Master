package LeetCodePatterns.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Indices: " + Arrays.toString(solution.twoSum(nums1, target1)));
        // Expected: [0, 1]  (because nums[0] + nums[1] = 2 + 7 = 9)
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ht = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (ht.containsKey(complement)) {
                ans[0] = ht.get(complement);
                ans[1] = i;
                break;
            }
            ht.put(nums[i], i);
        }

        return ans;
    }
}
