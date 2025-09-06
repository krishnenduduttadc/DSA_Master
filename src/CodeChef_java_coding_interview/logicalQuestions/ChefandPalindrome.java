package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Map;
import java.util.TreeMap;

public class ChefandPalindrome {
    public static void main(String[] args) {
        String s = "aaaabbbwwww";
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (tm.containsKey(s.charAt(i)) == true) {
                tm.put(s.charAt(i), (int) tm.get(s.charAt(i)) + 1);
            } else {
                tm.put(s.charAt(i), 1);
            }
        }

        int odd_count = 0;
        int even_count = 0;

        for (Map.Entry m : tm.entrySet()) {
            if ((int) m.getValue() % 2 != 0) {
                odd_count++;
            } else {
                even_count++;
            }
        }

        if (tm.size() == 1) {
            System.out.println("YES");
            System.exit(0);
        }

        if (tm.size() > 1 && (odd_count == 1 || odd_count == 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
