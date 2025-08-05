package RecursionAndBacktrackingL0;

import java.util.*;

public class StringPermutationDuplicate {
    public static void dfs(String str, String perm, List<String> list) {
        if (str.length() == 0) {
            list.add(perm);
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!set.contains(ch)) {
                String tmp = str.substring(0, i) + str.substring(i + 1);
                dfs(tmp, perm + ch, list);
            }
            set.add(ch);
        }

    }

    public static void main(String[] args) {
        String str = "aab";
        List<String> res = find_permutation(str);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static List<String> find_permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);
        List<String> list = new ArrayList<>();
        dfs(str, "", list);
        return list;
    }
}
