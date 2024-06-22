package StackL1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SmallerNoOnLeft {
    static List<Integer> leftSmaller(int n, int a[])
    {
        int [] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(st.size()>0 && a[i] < a[st.peek()]){
                int idx = st.pop();
                ans[idx] = a[i];
            }
            st.push(i);
        }
        while(st.size()>0){
            int idx = st.pop();
            ans[idx] = -1;
        }
        List<Integer> fans = new ArrayList<>();
        for(int ele : ans) fans.add(ele);
        return fans;
    }
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        int n = arr.length;

        List<Integer> result = leftSmaller(n, arr);

        System.out.println("Resulting list:");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
