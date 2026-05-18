package RecursionAndBacktrackingL2;

import java.util.HashMap;

public class PalindromicPermutations {

    public static void main(String[] args) {

        String str = "aabbc";

        HashMap<Character, Integer> fmap = new HashMap<>();

        for (char ch : str.toCharArray())
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

        Character odd = null;
        int odds = 0, len = 0;

        for (char ch : fmap.keySet()) {

            int f = fmap.get(ch);

            if (f % 2 == 1) {
                odd = ch;
                odds++;
            }

            fmap.put(ch, f / 2);
            len += f / 2;
        }

        if (odds > 1) {
            System.out.println(-1);
            return;
        }

        sol(1, len, fmap, odd, "");
    }

    private static void sol(int cs, int ts,
                            HashMap<Character, Integer> fmap,
                            Character oddc, String asf) {

        if (cs > ts) {

            String rev = new StringBuilder(asf).reverse().toString();

            System.out.println(
                    asf +
                            (oddc == null ? "" : oddc) +
                            rev
            );

            return;
        }

        for (char ch : fmap.keySet()) {
            int f = fmap.get(ch);
            if (f > 0) {
                fmap.put(ch, f - 1);
                sol(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, f);
            }
        }
    }
}