package DPL2;

import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("i");
        dict.add("like");
        dict.add("pep");
        dict.add("coding");
        dict.add("pepper");
        dict.add("eating");
        dict.add("mango");
        dict.add("man");
        dict.add("go");
        dict.add("in");
        dict.add("pepcoding");

        String sentence = "ilikepeppereatingmangoinpepcoding";
        System.out.println(wordBreak(sentence, dict));
    }

    static boolean wordBreak(String sentence, HashSet<String> dict) {
        int n = sentence.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case: empty string is segmentable

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = sentence.substring(j, i);
                if (dp[j] && dict.contains(sub)) {
                    dp[i] = true;
                    break; // once found, no need to check more
                }
            }
        }

        return dp[n];
    }
}
