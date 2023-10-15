package StackL2;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String S) {
        // complete this function
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);

            if(ch == '('){
                st.push(ch);
            } else {
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }

        return st.size();

    }

    public static void main(String[] args) throws Exception {
        int result = minAddToMakeValid("(()");
        System.out.println(result);
    }
}
