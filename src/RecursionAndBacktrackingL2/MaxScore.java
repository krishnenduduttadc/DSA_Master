package RecursionAndBacktrackingL2;

public class MaxScore {
    // Returns maximum score we can get from words[idx...end]
    static int maxScore(String[] words, int[] freq, int[] score, int idx) {

        // Base case
        if (idx == words.length) return 0;

        // Option 1: Skip current word
        int skip = maxScore(words, freq, score, idx + 1);

        String word = words[idx];
        int wordScore = 0;
        boolean canTake = true;

        // Try to take the word
        for (char ch : word.toCharArray()) {
            if (freq[ch - 'a'] == 0) {
                canTake = false;
            }
            freq[ch - 'a']--;
            wordScore += score[ch - 'a'];
        }

        int take = 0;
        if (canTake) {
            take = wordScore + maxScore(words, freq, score, idx + 1);
        }

        // Backtrack (restore frequency)
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        return Math.max(skip, take);
    }

    public static void main(String[] args) {

        // Hardcoded input
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'b', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {
                1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };

        // Build frequency array
        int[] freq = new int[26];
        for (char ch : letters) {
            freq[ch - 'a']++;
        }

        int result = maxScore(words, freq, score, 0);
        System.out.println("Maximum Score: " + result);
    }
}


