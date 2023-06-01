package RecursionAndBacktrackingL2;

import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        int n = 5;
        HashSet<String> dict = new HashSet<>();

        dict.add("microsoft");
        dict.add("hiring");
        dict.add("at");
        dict.add("kolkata");

        String sentence="microsofthiring";
        wordbreak(sentence,"",dict);

    }

    private static void wordbreak(String str, String ans, HashSet<String> dict) {
        if(str.length()==0){
            System.out.println(ans);

        }
        for (int i = 0; i < str.length(); i++) {
            String left=str.substring(0,i+1);
            if(dict.contains(left)){
                String right=str.substring(i+1);
                wordbreak(right,ans+left+" ",dict);
            }
            
        }
    }
}
