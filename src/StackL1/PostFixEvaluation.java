package StackL1;

import java.util.Stack;

public class PostFixEvaluation {

    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S) {
        Stack<Integer> op = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                int val2 = op.pop();
                int val1 = op.pop();
                int c = calc(val1, val2, ch);
                op.push(c);
            } else {
                op.push(ch - '0');
            }

        }
        return op.pop();
    }

    public static int calc(int a, int b, char c) {
        if (c == '+') return a + b;
        else if (c == '-') return a - b;
        else if (c == '*') return a * b;
        return a / b;
    }

    public static void main(String[] args) {
        String postfix1 = "231*+9-";
        System.out.println("Postfix: " + postfix1 + " -> Result: " + evaluatePostFix(postfix1)); // Expected: 4
    }
}



