package LeetCodePatterns.ArrayInterval;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        // Example 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println("Output: " + Arrays.deepToString(solution.insert(intervals1, newInterval1)));
        // Expected: [[1, 5], [6, 9]]

    }

    public int searchInsert(int[] nums, int target) {
        int ans = 0;
        int st = 0, end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                st = mid + 1;
                ans = st;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
