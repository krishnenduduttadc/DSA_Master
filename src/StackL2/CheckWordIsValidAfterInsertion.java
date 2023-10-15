package StackL2;

import java.util.Stack;

public class CheckWordIsValidAfterInsertion {
    public static boolean isValid(String S) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);

            if(ch == 'c'){
                if(st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a'){

                } else {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }

        return st.size() == 0;
    }

    public static void main(String[] args) throws Exception {
        boolean result = isValid("aabcbc");
        System.out.println(result);

    }
}
