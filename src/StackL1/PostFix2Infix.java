package StackL1;

import java.util.Stack;

public class PostFix2Infix {
    static String postToInfix(String exp) {
        Stack<String> op = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String val2 = op.pop();
                String val1 = op.pop();
                String cal = '(' + val1 + ch + val2 + ')';
                op.push(cal);
            } else {
                op.push(ch + "");
            }
        }
        return op.pop();
    }


    public static void main(String[] args) {
        String postfix1 = "ab+c*";
        System.out.println("Postfix: " + postfix1 + " -> Infix: " + postToInfix(postfix1)); // Expected: "(a+b)*c"
    }
}
