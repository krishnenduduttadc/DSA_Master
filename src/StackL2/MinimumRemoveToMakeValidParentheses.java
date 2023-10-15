package StackL2;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static String reverseParentheses(String s) {
        char chars[] = s.toCharArray();

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '('){
                st.push(i);
            } else if(chars[i] == ')'){
                if(st.size() == 0){
                    chars[i] = '.';
                } else {
                    st.pop();
                }
            }
        }

        while(st.size() > 0){
            chars[st.pop()] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(c != '.'){
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) throws Exception {
        String result = reverseParentheses("(a(b)c)d)");
        System.out.println(result);

    }
}
