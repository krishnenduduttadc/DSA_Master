package StackL2;

import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) throws Exception {
        // write your code here


        int nums[] = {5,7,6,10,4,9,3,2};
        int n=nums.length;
        int min[] = new int[n];
        min[0] = nums[0];
        for(int i = 1; i < n; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> st = new Stack<>();
        boolean found = false;
        for(int j = n - 1; j >= 0;j--){
            while(st.size() > 0 && st.peek() <= min[j])st.pop();
            if(st.size() > 0 && st.peek() < nums[j]){
                found = true;
                break;
            }
            st.push(nums[j]);
        }

        System.out.println(found);
    }

}
