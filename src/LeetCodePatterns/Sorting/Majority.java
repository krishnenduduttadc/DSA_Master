package LeetCodePatterns.Sorting;

public class Majority {

    public static void main(String[] args) {
        Majority solution = new Majority();

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = {1};

        System.out.println("Majority in nums1: " + solution.majorityElement(nums1)); // Expected: 3
        System.out.println("Majority in nums2: " + solution.majorityElement(nums2)); // Expected: 2
        System.out.println("Majority in nums3: " + solution.majorityElement(nums3)); // Expected: 1
    }

    public int majorityElement(int[] nums) {
        int mc = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == mc) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    mc = nums[i];
                    count = 1;
                }
            }
        }
        return mc;
    }
}
