package BinarySearchL1;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray solution = new FindMinimuminRotatedSortedArray();
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Minimum element in nums1: " + solution.findMin(nums1)); // Output: 1
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (nums[m] <= nums[hi]) {

                if (ans == -1 || nums[m] < nums[ans]) {
                    ans = m;
                }
                hi = m - 1;

            } else {
                if (ans == -1 || nums[lo] < nums[ans]) {
                    ans = lo;
                }
                lo = m + 1;

            }

        }
        return nums[ans];
    }
}
