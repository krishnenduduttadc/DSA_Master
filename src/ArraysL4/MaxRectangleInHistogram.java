package ArraysL4;

import java.util.Stack;

public class MaxRectangleInHistogram {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        Stack<Integer> s = new Stack<>();
        int r = 0, n = a.length;

        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || a[s.peek()] >= a[i])) {
                int h = a[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                r = Math.max(r, h * w);
            }
            s.push(i);
        }
        System.out.println(r);
    }
}
