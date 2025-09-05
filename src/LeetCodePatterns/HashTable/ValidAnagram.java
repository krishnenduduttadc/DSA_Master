package LeetCodePatterns.HashTable;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Test 1: " + solution.isAnagram(s1, t1));
        // Expected: true
    }

    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}
