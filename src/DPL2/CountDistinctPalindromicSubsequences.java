package DPL2;

import java.util.HashMap;

public class CountDistinctPalindromicSubsequences {
    public static int solution(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int[] prev = new int[str.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(map.containsKey(ch) == false){
                prev[i] = -1;
            } else {
                prev[i] = map.get(ch);
            }

            map.put(ch, i);
        }

        int[] next = new int[str.length()];
        map.clear();

        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);

            if(map.containsKey(ch) == false){
                next[i] = -1;
            } else {
                next[i] = map.get(ch);
            }

            map.put(ch, i);
        }

        for(int g = 0; g < str.length(); g++){
            for(int i = 0,  j = g; j < str.length(); i++, j++){
                if(g == 0){
                    dp[i][j] = 1;
                } else if(g == 1){
                    dp[i][j] = 2;
                } else {
                    char sc = str.charAt(i);
                    char ec = str.charAt(j);

                    if(sc != ec){
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    } else {
                        int n = next[i];
                        int p = prev[j];

                        if(n > p){
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if(n == p){
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[n + 1][p - 1];
                        }
                    }
                }
            }
        }

        return dp[0][str.length() - 1];
    }
    public static void main(String[] args) {

        String str = "ababda";
        System.out.println(solution(str));
    }
}
