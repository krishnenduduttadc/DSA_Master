package HeapL1;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfaDataStream {
    public static void main(String[] args) {
        // Create an instance of MedianFinder
        MedianOfaDataStream medianFinder = new MedianOfaDataStream();

        // Hardcoded array of numbers to be added
        int[] numbers = {1, 2, 3, 4, 5};

        // Add numbers to the MedianFinder and print the median each time
        for (int num : numbers) {
            medianFinder.addNum(num);
            System.out.println("Current median after adding " + num + ": " + medianFinder.findMedian());
        }
    }

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianOfaDataStream() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() == large.size()) {
            large.add(num);
            small.add(large.remove());
        } else {
            small.add(num);
            large.add(small.remove());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}
