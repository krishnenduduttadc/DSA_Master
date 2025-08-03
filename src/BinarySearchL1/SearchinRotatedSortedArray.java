package BinarySearchL1;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        // Example test cases
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Index of " + target1 + " in nums1: " + search(nums1, target1)); // Output: 4
    }

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Left half is sorted
            if (nums[lo] <= nums[mid]) {
                // Target is within the sorted left half
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            // Right half is sorted
            else {
                // Target is within the sorted right half
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }
}
