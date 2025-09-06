package LeetCodePatterns.DP;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    private Map<String, Integer> map;

    public static void main(String[] args) {
        TargetSum solver = new TargetSum();

        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println("Ways (nums=[1,1,1,1,1], target=3): " + solver.findTargetSumWays(nums1, target1));
        // Expected: 5
    }

    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return f(0, target, nums);
    }

    private int f(int i, int target, int[] nums) {
        String key = i + "-" + target;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (i < nums.length - 1) {
            map.put(key, f(i + 1, target - nums[i], nums) + f(i + 1, target + nums[i], nums));
            return map.get(key);
        } else {
            if (Math.abs(target) == Math.abs(nums[i])) {
                if (nums[i] == 0) {
                    return 2; // "+0" and "-0"
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }
    }
}
