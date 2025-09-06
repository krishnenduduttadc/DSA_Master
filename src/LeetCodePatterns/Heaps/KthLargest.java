package LeetCodePatterns.Heaps;

import java.util.PriorityQueue;

public class KthLargest {

    // Testing
    public static void main(String[] args) {
        KthLargest solver = new KthLargest();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("The " + k + "th largest element is: " + solver.findKthLargest(nums, k));
        // Expected: 5

        int[] nums2 = {7, 10, 4, 3, 20, 15};
        k = 3;
        System.out.println("The " + k + "rd largest element is: " + solver.findKthLargest(nums2, k));
        // Expected: 10
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add first k elements
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // Process remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= pq.peek()) {
                pq.add(nums[i]);
                pq.poll(); // remove smallest
            }
        }

        return pq.peek(); // kth largest
    }
}
