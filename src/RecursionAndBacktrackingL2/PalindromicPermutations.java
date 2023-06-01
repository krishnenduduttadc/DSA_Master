package RecursionAndBacktrackingL2;

import java.util.HashMap;

public class PalindromicPermutations {
    public static void main(String[] args) {
        String str = "aabbc";
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (fmap.containsKey(ch)) {
                int of = fmap.get(ch);
                int nf = of + 1;
                fmap.put(ch, nf);
            } else {
                fmap.put(ch, 1);
            }
        }

//        for (Character name: fmap.keySet()) {
//            String key = name.toString();
//            String value = fmap.get(name).toString();
//            System.out.println(key + " " + value);
//        }

        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq % 2 == 1) {
                odd = ch;
                odds++;
            }
            fmap.put(ch, freq / 2);
            len += freq / 2;
        }
        if (odds > 1) {
            System.out.println(-1);
            return;
        }
        sol(1, len, fmap, odd, "");
    }

    private static void sol(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if (cs > ts) {
            //System.out.println(asf+fmap);
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String res = asf;
            if (oddc != null) {
                res += oddc;
            }
            res += rev;
            System.out.println(res);
            return;
        }
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                sol(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }
}
