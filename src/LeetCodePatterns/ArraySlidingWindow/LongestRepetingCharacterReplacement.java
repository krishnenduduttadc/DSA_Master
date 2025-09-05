package LeetCodePatterns.ArraySlidingWindow;

public class LongestRepetingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepetingCharacterReplacement solution = new LongestRepetingCharacterReplacement();

        System.out.println(solution.characterReplacement("ABAB", 2)); // Expected: 4
        System.out.println(solution.characterReplacement("AABABBA", 1)); // Expected: 4
        System.out.println(solution.characterReplacement("AAAA", 2)); // Expected: 4
        System.out.println(solution.characterReplacement("ABBB", 2)); // Expected: 4
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];

        int maxCount = 0;
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
