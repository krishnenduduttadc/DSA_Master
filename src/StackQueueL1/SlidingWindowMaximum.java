package StackQueueL1;

import java.util.Stack;

public class SlidingWindowMaximum {

    public static void main(String[] args) throws Exception {
        int[] arr = {2, 9, 3, 8, 1, 7, 12, 6}; // hardcoded array
        int k = 4; // hardcoded window size

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        // Step 1: Fill NGE (Next Greater Element indices)
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        // Step 2: Use NGE to find max in every window of size k
        for (int i = 0; i <= arr.length - k; i++) {
            int j = i;
            while (nge[j] < i + k) {
                j = nge[j];
            }

            System.out.println(arr[j]);
        }
    }
}
