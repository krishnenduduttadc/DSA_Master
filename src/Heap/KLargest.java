package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargest {
    public static void main(String[] args) {
        // Hardcoded input array
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int l = 0;
        int r = arr.length - 1;

        // Call the kthSmallest method and store the result
        int result = kthSmallest(arr, l, r, k);

        // Print the result
        System.out.println("The " + k + "rd smallest element is " + result);
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i <= r; i++) {
            if (pq.peek() > arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }
}
