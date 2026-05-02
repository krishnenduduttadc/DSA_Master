package ArraysL4;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueofEquation {
    public static void main(String[] args) {
        int[][] p = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        int k = 1, r = Integer.MIN_VALUE;

        Deque<int[]> d = new ArrayDeque<>(); // {x, y-x}

        for (int[] v : p) {
            int x = v[0], y = v[1];

            while (!d.isEmpty() && x - d.peekFirst()[0] > k) d.pollFirst();

            if (!d.isEmpty())
                r = Math.max(r, d.peekFirst()[1] + y + x);

            int val = y - x;
            while (!d.isEmpty() && d.peekLast()[1] <= val) d.pollLast();
            d.addLast(new int[]{x, val});
        }
        System.out.println(r);
    }
}
