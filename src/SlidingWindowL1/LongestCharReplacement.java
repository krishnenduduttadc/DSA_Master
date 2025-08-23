package SlidingWindowL1;

public class LongestCharReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println("Longest substring with replacement = " + maxLen);
    }
}
