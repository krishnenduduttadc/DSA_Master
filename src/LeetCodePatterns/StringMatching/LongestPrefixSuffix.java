package LeetCodePatterns.StringMatching;

import java.util.Arrays;

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        String str = "ABABCA";
        System.out.println(Arrays.toString(lps_bruteforce(str)));
        System.out.println(Arrays.toString(lps(str)));

    }

    public static int[] lps(String str) {
        int n = str.length();
        int[] lps = new int[n];
        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && str.charAt(j) != str.charAt(i)) {
                j = lps[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }

    public static int[] lps_bruteforce(String str) {
        int n = str.length();
        int[] lps = new int[n];
        lps[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= i; k++) {
                if (str.substring(0, k).equals(str.substring(i - k + 1, i + 1))) {
                    lps[i] = k;
                }
            }
        }
        return lps;
    }
}
