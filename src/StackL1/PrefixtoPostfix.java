package StackL1;

import java.util.Stack;

public class PrefixtoPostfix {
    static String preToPost(String exp) {
        Stack<String> op = new Stack<>();
        int n = exp.length();
        for(int i = n-1; i>=0; i--){
            char ch = exp.charAt(i);
            if(ch=='+' || ch == '-' || ch == '*' || ch == '/'){
                String val1 = op.pop();
                String val2 = op.pop();
                String cal = val1+ val2 + ch;
                op.push(cal);
            } else {
                op.push(ch+"");
            }
        }
        return op.pop();
    }
    public static void main(String[] args) {
        String prefix1 = "*+AB-CDE";
        System.out.println("Prefix: " + prefix1 + " -> Postfix: " + preToPost(prefix1)); // Expected: "ABC+DE-*"

        String prefix2 = "*-A/BC-/DEFG";
        System.out.println("Prefix: " + prefix2 + " -> Postfix: " + preToPost(prefix2)); // Expected: "ABC/-DE/FG-*"

        // Add more test cases as needed
    }
}
