package HML2;

import java.util.HashMap;

public class Longestcontiguoussubarraywithequalnoofevenodd {
    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4, 1, 8, 2, 6, 4, 3};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums3 = {2, 5, 4, 1, 8, 3, 6, 4, 3};

        System.out.println("Length of longest contiguous subarray in nums1: " + findMaxLength(nums1));
        System.out.println("Length of longest contiguous subarray in nums2: " + findMaxLength(nums2));
        System.out.println("Length of longest contiguous subarray in nums3: " + findMaxLength(nums3));
    }

    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                count += 1;
            } else {
                count += -1;
            }
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
