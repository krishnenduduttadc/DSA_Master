package ArraysL4;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4};
        int n = a.length;
        long r = 0;

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || a[s.peek()] > a[i])) {
                int j = s.pop();
                int l = s.isEmpty() ? j + 1 : j - s.peek();
                int rr = i - j;
                r += 1L * a[j] * l * rr;
            }
            s.push(i);
        }
        System.out.println(r);
    }
}
