package ArraysL4;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        PriorityQueue<Integer> l = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> r = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            if (l.isEmpty() || a[i] <= l.peek()) l.add(a[i]);
            else r.add(a[i]);

            if (l.size() > r.size() + 1) r.add(l.poll());
            if (r.size() > l.size()) l.add(r.poll());

            if (i >= k) {
                if (a[i - k] <= l.peek()) l.remove(a[i - k]);
                else r.remove(a[i - k]);
            }

            if (i >= k - 1)
                System.out.print(l.peek() + " ");
        }
    }
}
