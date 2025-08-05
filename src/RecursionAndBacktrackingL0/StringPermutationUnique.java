package RecursionAndBacktrackingL0;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationUnique {
    static void dfs(String str, String perm, List<String> list) {
        if (str.length() == 0) {
            list.add(perm);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String tmp = str.substring(0, i) + str.substring(i + 1);
                dfs(tmp, perm + ch, list);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> list = new ArrayList<>();
        dfs(str, "", list);
        for (String s : list) {
            System.out.println(s);
        }

    }

}
