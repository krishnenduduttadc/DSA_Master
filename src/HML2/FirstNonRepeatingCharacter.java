package HML2;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abbcaddecfab";
        System.out.println(sol(s));
    }

    static int sol(String s) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            fmap.put(c, fmap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (fmap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}
