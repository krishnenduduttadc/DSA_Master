package StackQueueL1;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) throws Exception {
        int[][] arr = {
                {0, 0, 0, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print its index (not position), if not then print "none"
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                st.push(j); // i knows j => i can't be celeb
            } else {
                st.push(i); // i doesn't know j => j can't be celeb
            }
        }

        int pot = st.pop();
        boolean flag = true;

        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(pot);
        } else {
            System.out.println("none");
        }
    }
}
