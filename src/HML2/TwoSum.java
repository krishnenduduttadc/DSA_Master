package HML2;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        int[] result1 = twoSum(nums1, target1);
        int[] result2 = twoSum(nums2, target2);

        System.out.println("Output for nums1: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Output for nums2: [" + result2[0] + ", " + result2[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int com=target-nums[i];
            if(map.containsKey(com)){
                return new int[]{map.get(com),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
