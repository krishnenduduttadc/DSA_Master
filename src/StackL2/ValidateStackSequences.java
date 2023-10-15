package StackL2;

import java.util.Stack;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int j = 0;

        for(int e : pushed){
            st.push(e);
            while(st.size() > 0 && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }

        return j == popped.length;
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }

    public static void main(String[] args) throws Exception {

        int pushed [] = {7,2,9,4,5};
        int popped [] = {4,5,9,2,7};

        boolean result = validateStackSequences(pushed, popped);

        System.out.println(result);
    }
}
