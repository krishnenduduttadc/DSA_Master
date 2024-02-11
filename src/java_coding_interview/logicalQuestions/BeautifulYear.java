package java_coding_interview.logicalQuestions;

import java.util.HashSet;
import java.util.Set;

public class BeautifulYear {
    public static void main(String[] args) {
        solve();

    }

    static void solve() {
        int input = 1987;
        input++;
        while (true) {
            if (check(input)) {
                System.out.println(input);
                return;
            }
            input++;
        }
    }

    static boolean check(int num) {
        String str = Integer.toString(num);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }
}
