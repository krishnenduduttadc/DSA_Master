package ArraysL4;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        int[] m = new int[128];
        for (char c : t.toCharArray()) m[c]++;

        int l = 0, c = t.length(), ml = Integer.MAX_VALUE, st = 0;

        for (int r = 0; r < s.length(); r++) {
            if (m[s.charAt(r)]-- > 0) c--;

            while (c == 0) {
                if (r - l + 1 < ml) {
                    ml = r - l + 1;
                    st = l;
                }
                if (++m[s.charAt(l++)] > 0) c++;
            }
        }

        System.out.println(ml == Integer.MAX_VALUE ? "" : s.substring(st, st + ml));
    }
}
