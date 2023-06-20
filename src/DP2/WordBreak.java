package DP2;

import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        HashSet<String> dict=new HashSet<>();
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

        String sentence="ilikepeppereatingmangoinpepcoding";
        System.out.println(solution(sentence,dict));

    }

    static boolean solution(String sentence, HashSet<String> dict) {
        int[] dp = new int[sentence.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String w2check = sentence.substring(j, i + 1);
                if (dict.contains(w2check)) {
                    if (j > 0) {
                        dp[i] += dp[j - 1];
                    } else {
                        dp[i] += 1;
                    }
                }

            }
        }
        System.out.println(dp[sentence.length()-1]);
        return dp[sentence.length() - 1] > 0;
    }
}
