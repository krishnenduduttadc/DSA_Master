package GraphL3;

import java.util.*;

public class Word_Ladder_2 {

    public static void main(String[] args) {

        String startWord = "der";
        String targetWord = "dfs";

        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }

    public static int wordLadderLength(String startWord,
                                       String targetWord,
                                       String[] wordList) {

        Set<String> words = new HashSet<>(Arrays.asList(wordList));
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(startWord, 1));
        words.remove(startWord);

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            if (current.word.equals(targetWord))
                return current.steps;

            char[] chars = current.word.toCharArray();

            for (int i = 0; i < chars.length; i++) {

                char original = chars[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    chars[i] = ch;
                    String nextWord = new String(chars);

                    if (words.contains(nextWord)) {
                        queue.offer(new Pair(nextWord, current.steps + 1));
                        words.remove(nextWord);
                    }
                }

                chars[i] = original;
            }
        }

        return 0;
    }

    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}