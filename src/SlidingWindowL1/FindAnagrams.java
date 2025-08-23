package SlidingWindowL1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        int[] countP = new int[26], countS = new int[26];
        for (char c : p.toCharArray()) countP[c - 'a']++;

        List<Integer> result = new ArrayList<>();
        int k = p.length();

        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            if (i >= k) countS[s.charAt(i - k) - 'a']--;

            if (Arrays.equals(countS, countP)) result.add(i - k + 1);
        }

        System.out.println("Anagram indices = " + result);
    }
}

