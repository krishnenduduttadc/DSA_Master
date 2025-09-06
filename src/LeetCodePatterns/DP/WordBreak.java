package LeetCodePatterns.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // Main method to test the program
    public static void main(String[] args) {
        WordBreak solver = new WordBreak();

        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Can \"" + s1 + "\" be segmented? " + solver.wordBreak(s1, dict1));

        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Can \"" + s2 + "\" be segmented? " + solver.wordBreak(s2, dict2));

        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Can \"" + s3 + "\" be segmented? " + solver.wordBreak(s3, dict3));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> validWords = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int start = 0; start < i && !dp[i]; start++) {
                dp[i] = dp[start] && validWords.contains(s.substring(start, i));
            }
        }

        return dp[n];
    }
}
