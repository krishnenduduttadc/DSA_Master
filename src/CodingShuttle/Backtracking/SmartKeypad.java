package CodingShuttle.Backtracking;

import java.util.ArrayList;

public class SmartKeypad {
    public static void main(String[] args) {
        String input = "23";
        System.out.println(smartKeypad(input));
    }

    static ArrayList<String> smartKeypad(String input) {
        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        ArrayList<String> ans = new ArrayList<>();
        smartKeypadHelper(input, map, 0, ans, "");
        return ans;
    }

    static void smartKeypadHelper(String input, String[] map, int index, ArrayList<String> ans, String cur) {
        if (index == input.length()) {
            ans.add(cur);
            return;
        }
        int keypadNumber = input.charAt(index) - '0';
        String keypadString = map[keypadNumber];

        for (int i = 0; i < keypadString.length(); i++) {
            smartKeypadHelper(input, map, index + 1, ans, cur + keypadString.charAt(i));
        }
    }
}
