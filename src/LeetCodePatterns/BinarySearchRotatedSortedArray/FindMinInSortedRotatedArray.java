package LeetCodePatterns.BinarySearchRotatedSortedArray;

public class FindMinInSortedRotatedArray {
    public static void main(String[] args) {
        FindMinInSortedRotatedArray solver = new FindMinInSortedRotatedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Result 1: " + solver.findMin(nums1)); // Expected 1
        System.out.println("Result 2: " + solver.findMin(nums2)); // Expected 0
        System.out.println("Result 3: " + solver.findMin(nums3)); // Expected 11
    }

    public int findMin(int[] nums) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;

        int ans = nums[0];

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] <= nums[n - 1]) {
                ans = nums[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;

    }
}
