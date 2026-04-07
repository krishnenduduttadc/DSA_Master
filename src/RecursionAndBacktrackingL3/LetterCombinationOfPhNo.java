package RecursionAndBacktrackingL3;

public class LetterCombinationOfPhNo {

    static String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {

        String digits = "23";

        backtrack(digits, 0, "");
    }

    public static void backtrack(String digits, int index, String current) {

        if (index == digits.length()) {
            System.out.println(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            backtrack(digits, index + 1, current + c);
        }
    }

}
