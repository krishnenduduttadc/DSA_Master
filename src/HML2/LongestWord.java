package HML2;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWord {
    public static void main(String[] args) {
        String[] words1 = {"w", "wo", "wor", "worl", "world"};
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        System.out.println("Longest word in words1: " + longestWord(words1));
        System.out.println("Longest word in words2: " + longestWord(words2));
    }

    public static String longestWord(String[] words) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        String longestWord = "";

        for (String word : words) {
            boolean isValid = true;
            for (int i = 1; i < word.length(); i++) {
                if (!wordSet.contains(word.substring(0, i))) {
                    isValid = false;
                    break;
                }
            }
            // If the word is valid and it's longer than the current longest word
            if (isValid && (word.length() > longestWord.length() || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0))) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
