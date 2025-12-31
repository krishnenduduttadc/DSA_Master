package HML2;

import java.util.HashMap;

public class LongestSubstringWithNonRepetingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

//    public static int solution(String str) {
//        // write your code here
//        int ans = 0;
//        int i = -1;
//        int j = -1;
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        while (true) {
//            boolean f1 = false;
//            boolean f2 = false;
//
//            while (i < str.length() - 1) {
//                f1 = true;
//                i++;
//                char ch = str.charAt(i);
//                map.put(ch, map.getOrDefault(ch, 0) + 1);
//
//                if (map.get(ch) == 2) {
//                    break;
//                } else {
//                    int len = i - j;
//                    if (len > ans) {
//                        ans = len;
//                    }
//                }
//            }
//
//            while (j < i) {
//                f2 = true;
//                j++;
//                char ch = str.charAt(j);
//                map.put(ch, map.get(ch) - 1);
//                if (map.get(ch) == 1) {
//                    break;
//                }
//            }
//
//            if (f1 == false && f2 == false) {
//                break;
//            }
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        //System.out.println(solution(str));
        System.out.println(lengthOfLongestSubstring(str));
    }
}


