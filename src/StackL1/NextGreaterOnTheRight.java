package StackL1;

import java.util.Stack;

public class NextGreaterOnTheRight {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans = new long[n];
        Stack<Integer> st = new Stack();
        for(int i = 0; i<n; i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = arr[i];
            }
            st.push(i);
        }
        while(st.size()>0){
            int idx = st.pop();
            ans[idx] = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {4, 8, 5, 2, 25};
        int n = arr.length;

        long[] result = nextLargerElement(arr, n);

        System.out.println("Resulting array:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
