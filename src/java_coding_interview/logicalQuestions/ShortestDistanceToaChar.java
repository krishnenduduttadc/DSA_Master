package java_coding_interview.logicalQuestions;

import java.util.TreeSet;

public class ShortestDistanceToaChar {
    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        int[] res = shortest(S, C);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] shortest(String S, char C) {
        TreeSet<Integer> ts = new TreeSet<>();
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                ts.add(i);
            }
        }
        System.out.println(ts);
        for (int i = 0; i < S.length(); i++) {
            Integer low = ts.floor(i);
            Integer high = ts.ceiling(i);
            if (high == null || (low != null && i - low < high - i)) {
                result[i] = i - low;
            } else {
                result[i] = high - i;
            }
        }
        return result;
    }
}
