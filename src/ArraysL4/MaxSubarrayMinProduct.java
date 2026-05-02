package ArraysL4;

import java.util.Stack;

public class MaxSubarrayMinProduct {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2};
        int n = a.length;
        long[] p = new long[n + 1];
        for (int i = 0; i < n; i++) p[i + 1] = p[i] + a[i];

        Stack<Integer> s = new Stack<>();
        long r = 0;

        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || a[s.peek()] >= a[i])) {
                int j = s.pop();
                int l = s.isEmpty() ? 0 : s.peek() + 1;
                int rr = i - 1;
                long sum = p[rr + 1] - p[l];
                r = Math.max(r, sum * a[j]);
            }
            s.push(i);
        }
        System.out.println(r);
    }
}
