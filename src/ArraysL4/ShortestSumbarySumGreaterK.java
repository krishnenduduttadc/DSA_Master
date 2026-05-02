package ArraysL4;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSumbarySumGreaterK {
    public static void main(String[] args) {
        int[] a = {2, -1, 2};
        int k = 3, n = a.length;
        long[] p = new long[n + 1];

        for (int i = 0; i < n; i++) p[i + 1] = p[i] + a[i];

        Deque<Integer> d = new ArrayDeque<>();
        int r = n + 1;

        for (int i = 0; i <= n; i++) {
            while (!d.isEmpty() && p[i] - p[d.peekFirst()] >= k)
                r = Math.min(r, i - d.pollFirst());

            while (!d.isEmpty() && p[i] <= p[d.peekLast()])
                d.pollLast();

            d.addLast(i);
        }
        System.out.println(r == n + 1 ? -1 : r);
    }
}
