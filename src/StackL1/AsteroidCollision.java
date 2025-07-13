package StackL1;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5, -10, 8, -8};
        int[] result = asteroidCollision(asteroids);
        System.out.println("Final Output: " + Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                int top = st.peek();

                if (top < -asteroid) {
                    st.pop();
                    continue;
                } else if (top == -asteroid) {
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
