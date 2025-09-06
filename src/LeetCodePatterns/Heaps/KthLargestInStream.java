package LeetCodePatterns.Heaps;

import java.util.PriorityQueue;

public class KthLargestInStream {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    // Testing
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargestInStream kthLargest = new KthLargestInStream(3, nums);

        System.out.println(kthLargest.add(3));  // returns 4
        System.out.println(kthLargest.add(5));  // returns 5
        System.out.println(kthLargest.add(10)); // returns 5
        System.out.println(kthLargest.add(9));  // returns 8
        System.out.println(kthLargest.add(4));  // returns 8
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
