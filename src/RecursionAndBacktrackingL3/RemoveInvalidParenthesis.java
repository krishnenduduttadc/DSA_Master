package RecursionAndBacktrackingL3;

import java.util.HashSet;
import java.util.Set;

public class RemoveInvalidParenthesis {


    static Set<String> result = new HashSet<>();

    public static void main(String[] args) {

        String s = "()())()";
        int leftRemove = 0, rightRemove = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') leftRemove++;
            else if (c == ')') {
                if (leftRemove == 0) rightRemove++;
                else leftRemove--;
            }
        }

        backtrack(s, 0, leftRemove, rightRemove);
        for (String str : result)
            System.out.println(str);
    }

    public static void backtrack(String s, int index,
                                 int leftRemove, int rightRemove) {

        if (leftRemove == 0 && rightRemove == 0) {
            if (isValid(s))
                result.add(s);
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (i != index && s.charAt(i) == s.charAt(i - 1))
                continue;

            if (leftRemove > 0 && s.charAt(i) == '(') {
                backtrack(s.substring(0, i) + s.substring(i + 1),
                        i, leftRemove - 1, rightRemove);
            }

            if (rightRemove > 0 && s.charAt(i) == ')') {
                backtrack(s.substring(0, i) + s.substring(i + 1),
                        i, leftRemove, rightRemove - 1);
            }
        }
    }

    public static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }

}
