package StackL2;

import java.util.Stack;

public class NoOfValidSubarrays {
    public static int validSubarrays(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans= 0;

        for(int i = nums.length - 1; i >= 0;i--){
            int val = nums[i];
            while(st.size() > 0 && nums[st.peek()] >= val)st.pop();
            int si = nums.length;
            if(st.size() > 0)si = st.peek();
            ans += si - i;
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        int nums[] = {2,4,2,1,3};
        int count = validSubarrays(nums);
        System.out.println(count);

    }
}
