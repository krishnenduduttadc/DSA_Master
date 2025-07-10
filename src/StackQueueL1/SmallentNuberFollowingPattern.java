package StackQueueL1;

import java.util.Stack;

public class SmallentNuberFollowingPattern {

    public static void main(String[] args) throws Exception {
        String str = "ddddiiii";  // hardcoded pattern

        Stack<Integer> st = new Stack<>();
        int num = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'd') {
                st.push(num);
                num++;
            } else if (ch == 'i') {
                st.push(num);
                num++;

                while (!st.isEmpty()) {
                    System.out.print(st.pop());
                }
            }
        }

        // Push the last number and print any remaining stack content
        st.push(num);
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
    }
}
