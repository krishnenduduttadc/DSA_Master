package HashMapAndHeap2;

import java.util.HashMap;

public class ValidAnagrams {
    public static void main(String[] args) {
        String s1 = "abbcaad";
        String s2 = "babacda";
        System.out.println(sol(s1,s2));
    }

    static boolean sol(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.containsKey(ch) == false) {
                return false;
            } else if (map.get(ch) == 1) {
                map.remove(ch);
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.size() == 0;
    }
}
