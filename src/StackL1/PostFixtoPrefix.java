package StackL1;

import java.util.Stack;

public class PostFixtoPrefix {
        static String postToPre(String exp) {
            Stack<String> op = new Stack<>();
            for(int i = 0; i<exp.length(); i++){
                char ch = exp.charAt(i);
                if(ch=='+' || ch == '-' || ch == '*' || ch == '/'){
                    String val2 = op.pop();
                    String val1 = op.pop();
                    String cal = ch+val1+val2;
                    op.push(cal);
                } else {
                    op.push(ch+"");
                }
            }
            return op.pop();
        }

    public static void main(String[] args) {
        String postfix1 = "ab+c*";
        System.out.println("Postfix: " + postfix1 + " -> Prefix: " + postToPre(postfix1)); // Expected: "*+abc"
    }

    }
