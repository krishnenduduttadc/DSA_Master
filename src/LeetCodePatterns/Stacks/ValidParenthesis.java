package LeetCodePatterns.Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis solution = new ValidParenthesis();

        System.out.println(solution.isValid("()"));       // true
        System.out.println(solution.isValid("()[]{}"));   // true
        System.out.println(solution.isValid("(]"));       // false
        System.out.println(solution.isValid("([)]"));     // false
        System.out.println(solution.isValid("{[]}"));     // true
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    return false;
                } else {
                    char och = st.peek();
                    if ((och == '(' && ch == ')') || (och == '{' && ch == '}') || (och == '[' && ch == ']')) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (st.size() == 0) {
            return true;
        }
        return false;
    }
}
