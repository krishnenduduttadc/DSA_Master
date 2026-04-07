package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    public static void main(String[] args) {
        String s = "aab";
        backtrack(s, 0, new ArrayList<>());
    }

    public static void backtrack(String s, int start, List<String> current) {

        if (start == s.length()) {
            System.out.println(current);
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                current.add(s.substring(start, end + 1));

                backtrack(s, end + 1, current);

                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

}
