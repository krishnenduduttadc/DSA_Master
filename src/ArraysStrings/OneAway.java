package ArraysStrings;

public class OneAway {
    public static void main(String[] args) {

        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pale", "bae"));

    }

    static boolean oneEditAway(String f, String s) {
        if (f.length() == s.length()) {
            return oneEditReplace(f, s);
        } else if (f.length() + 1 == s.length()) {
            return oneEditInsert(f, s);
        } else if (f.length() - 1 == s.length()) {
            return oneEditInsert(s, f);
        }
        return false;
    }

    static boolean oneEditReplace(String s1, String s2) {
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }

    static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
