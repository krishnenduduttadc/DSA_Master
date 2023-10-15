package StackL2;

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        // complete this function
        Stack<Integer> st = new Stack<>();

        for(int val : asteroids){
            if(val > 0){
                st.push(val);
            } else {
                while(st.size() > 0 && st.peek() > 0 && st.peek() < -val){
                    st.pop();
                }
                if(st.size() > 0 && st.peek() == -val){
                    st.pop();
                } else if(st.size() > 0 && st.peek() > -val){

                } else {
                    st.push(val);
                }
            }
        }

        int ans[] = new int[st.size()];
        int i = ans.length - 1;
        while(i >= 0)ans[i--] = st.pop();

        return ans;
    }

    public static void main(String[] args) throws Exception {

        int arr[] = {-1,1,2,-1,3,-3,3};
        int result[] = asteroidCollision(arr);

        System.out.println(result.length);
        for (int e : result) {
            System.out.println(e);
        }

    }
}
