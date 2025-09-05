package LeetCodePatterns.BinarySearchRotatedSortedArray;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        FirstAndLastPosition solver = new FirstAndLastPosition();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int[] nums3 = {};

        System.out.println("Result 1: " + Arrays.toString(solver.searchRange(nums1, 8))); // Expected [3,4]
        System.out.println("Result 2: " + Arrays.toString(solver.searchRange(nums2, 6))); // Expected [-1,-1]
        System.out.println("Result 3: " + Arrays.toString(solver.searchRange(nums3, 0))); // Expected [-1,-1]
    }

    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    private int findLeft(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                end = mid - 1; // keep searching left
            }
        }

        return ans;
    }

    private int findRight(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1; // keep searching right
            }
        }

        return ans;
    }
}
