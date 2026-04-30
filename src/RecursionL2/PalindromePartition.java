package RecursionL2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        f(0, "aab", new ArrayList<>());
    }

    static boolean palin(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    static void f(int i, String s, List<String> l) {
        if (i == s.length()) {
            System.out.println(l);
        }
        for (int j = i; j < s.length(); j++) {
            if (palin(s, i, j)) {
                l.add(s.substring(i, j + 1));
                f(i + 1, s, l);
                l.remove(l.size() - 1);
            }
        }
    }
}
