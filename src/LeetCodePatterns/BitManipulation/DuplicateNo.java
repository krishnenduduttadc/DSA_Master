package LeetCodePatterns.BitManipulation;

public class DuplicateNo {
    // Main method to test the program
    public static void main(String[] args) {
        DuplicateNo solver = new DuplicateNo();

        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate in [1,3,4,2,2]: " + solver.findDuplicate(nums1));

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate in [3,1,3,4,2]: " + solver.findDuplicate(nums2));

        int[] nums3 = {1, 1};
        System.out.println("Duplicate in [1,1]: " + solver.findDuplicate(nums3));

        int[] nums4 = {1, 1, 2};
        System.out.println("Duplicate in [1,1,2]: " + solver.findDuplicate(nums4));
    }

    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;

        int ans = 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }
}
