package StackL1;

import java.util.Stack;

public class LongestUnbalancedSubsequence {
    public static void main(String[] args) {
        // Hardcoded input for demonstration
        String s = "{[()]}";  // Example input, change as needed

        int len = s.length();
        if (isValid(s)) {
            System.out.println(len - 1);
        } else {
            System.out.println(len);
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if ((ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '[') || (ch == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            i++;
        }

        return stack.isEmpty();
    }
}
