package StackQueueL1;

import java.util.Stack;

public class NextGreaterToRight {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        int[] a = {5, 3, 8, -2, 7}; // hardcoded input

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];

        st.push(arr[arr.length - 1]);
        nge[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return nge;
    }
}
