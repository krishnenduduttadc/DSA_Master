package StackL1;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        // Hardcoded input array of asteroids
        int[] asteroids = {5, 10, -5, -10, 8, -8};

        // Call the asteroidCollision method and store the result
        int[] result = asteroidCollision(asteroids);

        // Print the result array
        System.out.println(Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        int i = 0;

        while (i < n) {
            if (asteroids[i] < 0) {
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                    i++;
                } else if (st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                    i++;
                } else if (st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                } else if (st.peek() > Math.abs(asteroids[i])) {
                    i++;
                }
            } else {
                st.push(asteroids[i]);
                i++;
            }
        }

        int[] ans = new int[st.size()];
        for (int j = ans.length - 1; j >= 0; j--) {
            ans[j] = st.pop();
        }

        return ans;
    }
}
