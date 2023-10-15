package StackL2;

import java.util.Stack;

public class LargestAreaHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        st.push(-1);
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){
            int val = i == heights.length?0:heights[i];

            while(st.peek() != -1 && heights[st.peek()] >=  val){
                int rm = i;
                int h = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea, h*(rm-lm-1));
            }

            st.push(i);
        }


        return maxArea;
    }

    public static void main(String[] args) throws Exception {
        int heights[] = {5,2,6,7};
        System.out.println(largestRectangleArea(heights));

    }
}
