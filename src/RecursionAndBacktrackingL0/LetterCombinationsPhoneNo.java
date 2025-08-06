package RecursionAndBacktrackingL0;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNo {
    public static void main(String[] args) {
        LetterCombinationsPhoneNo obj = new LetterCombinationsPhoneNo();
        String digits = "23";

        List<String> result = obj.letterCombinations(digits);

        System.out.println("Letter combinations for digits \"" + digits + "\":");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits.length() == 0) return list;

        list.add("");
        String[] map = new String[]{
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() == i) {
                String tmp = list.remove();
                for (char ch : map[index].toCharArray()) {
                    list.add(tmp + ch);
                }
            }
        }

        return list;
    }
}
