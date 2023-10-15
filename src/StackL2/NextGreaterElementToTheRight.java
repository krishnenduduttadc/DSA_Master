package StackL2;

import java.util.Stack;

public class NextGreaterElementToTheRight {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        int[] a = {2,5,9,3,1,12,6,8,7};
        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr){
        int n = arr.length;
        int ngl[] = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(st.size() > 0 && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.size() > 0){
                ngl[i] = st.peek();
            } else {
                ngl[i] = -1;
            }

            st.push(arr[i]);
        }

        return ngl;
    }
}
