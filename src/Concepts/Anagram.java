package Concepts;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String string1 = "krishnendu";
        String string2 = "nendukrish";
        if (string1.length() == string2.length()) {
            char[] f = string1.toCharArray();
            char[] s = string2.toCharArray();

            Arrays.sort(f);
            Arrays.sort(s);

            boolean r = Arrays.equals(f, s);
            System.out.println(r);
        }
    }
}
