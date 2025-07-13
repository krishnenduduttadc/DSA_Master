package QueueL1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        // Example 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.println("Max sliding window for nums1 and k=" + k1 + ": " + Arrays.toString(result1));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (deque.size() > 0 && deque.getLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        ans[0] = deque.getFirst();
        for (int i = k; i < n; i++) {
            if (nums[i - k] == deque.getFirst()) deque.removeFirst();
            while (deque.size() > 0 && deque.getLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            ans[i - k + 1] = deque.getFirst();

        }
        return ans;
    }

}
