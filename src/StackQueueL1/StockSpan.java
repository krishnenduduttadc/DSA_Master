package StackQueueL1;

import java.util.Stack;

public class StockSpan {

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        int[] a = {100, 80, 60, 70, 60, 75, 85}; // Hardcoded stock prices

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        int[] span = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        span[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
    }
}
