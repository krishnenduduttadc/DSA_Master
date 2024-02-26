package java_coding_interview.logicalQuestions;

import java.util.Stack;

public class NumberofVisiblePeopleinaQueue {
    public static void main(String[] args) {
        int[] arr = {10, 6, 8, 5, 11, 9};
        int[] res = cansee(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static int[] cansee(int[] heights) {
        int[] result = new int[heights.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            while (!stack.isEmpty() && stack.peek()[0] < h) {
                int prev = stack.pop()[1];
                result[prev]++;
            }
            if (!stack.isEmpty()) {
                result[stack.peek()[1]]++;
            }
            stack.push(new int[]{h, i});
        }
        return result;
    }
}
