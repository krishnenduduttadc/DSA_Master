package CodingShuttle.StringTrie;

public class RabinKarp {
    static final int CHAR_SIZE = 26;
    static final int M = (int) (1e9 + 7);

    public static void main(String[] args) {
        String s = "abcdabce";
        String p = "abce";

        System.out.println(rabinKarpMatching(s, p));
    }

    static int rabinKarpMatching(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (n < m) return -1;

        int hp = rollingHash(p, m);
        int hs = rollingHash(s, m);

        for (int i = m; i < n; i++) {
            if (hp == hs) {
                if (isExactMatch(s, i - m, p)) {
                    return i - m;
                }
            }
            hs -= (Math.pow(CHAR_SIZE, m - 1) % M * (s.charAt(i - m) - 'a' + 1)) % M;
            hs *= CHAR_SIZE;
            hs += (s.charAt(i) - 'a' + 1);
            hs %= M; // Ensure hs stays within bounds
        }
        if (hp == hs) {
            if (isExactMatch(s, n - m, p)) return n - m;
        }
        return -1;
    }

    static boolean isExactMatch(String s, int ind, String p) {
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(i + ind) != p.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static int rollingHash(String s, int size) {
        int hash = 0;
        for (int i = 0; i < size; i++) {
            hash += (Math.pow(CHAR_SIZE, size - 1 - i) % M * (s.charAt(i) - 'a' + 1)) % M;
            hash %= M; // Ensure hash stays within bounds
        }
        return hash;
    }
}
