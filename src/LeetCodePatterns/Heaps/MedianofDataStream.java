package LeetCodePatterns.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianofDataStream {
    private PriorityQueue<Integer> maxHeap; // left half
    private PriorityQueue<Integer> minHeap; // right half

    public MedianofDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // Testing
    public static void main(String[] args) {
        MedianofDataStream mf = new MedianofDataStream();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 2.0
        mf.addNum(4);
        mf.addNum(5);
        System.out.println("Median: " + mf.findMedian()); // 3.0
    }

    public void addNum(int num) {
        maxHeap.offer(num);                 // step 1: add to maxHeap
        minHeap.offer(maxHeap.poll());      // step 2: balance -> move max to minHeap

        if (maxHeap.size() < minHeap.size()) { // step 3: ensure size property
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // odd size
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // even size
        }
    }
}
