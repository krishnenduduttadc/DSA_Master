package StackL2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        // write your code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(st.size() > 0){
                    sb.append(ch);
                }
                st.push(ch);
            } else {
                st.pop();
                if(st.size() > 0){
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeOuterParentheses("(())(()())");
        System.out.println(result);
    }
}
