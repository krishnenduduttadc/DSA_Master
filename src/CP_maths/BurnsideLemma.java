package CP_maths;

class BurnsideLemma {
    /*
    ===============================================================
        Burnside’s Lemma – Counting Necklaces
    ===============================================================

    Problem:
      Count distinct necklaces of n beads using k colors,
      where two are the same if one can be rotated into another.

    Formula:
      Necklaces(n, k) = (1/n) * Σ ( k^gcd(n, r) ) for r=0..n-1

    Example:
      n=3, k=2 (3 beads, 2 colors)
      Rotations: r=0 → 2^3=8
                 r=1 → 2^gcd(3,1)=2
                 r=2 → 2^gcd(3,2)=2
      Total = (8+2+2)/3 = 12/3 = 4

    So, 4 distinct necklaces.
    ===============================================================
    */

    static final long MOD = 1000000007;

    // Fast exponentiation
    static long modPow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    // gcd
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Burnside’s Lemma for necklace counting
    static long countNecklaces(int n, int k) {
        long sum = 0;
        for (int r = 0; r < n; r++) {
            int g = gcd(n, r);
            sum = (sum + modPow(k, g)) % MOD;
        }
        // multiply by modular inverse of n
        long invN = modPow(n, MOD - 2);
        return (sum * invN) % MOD;
    }

    public static void main(String[] args) {
        System.out.println("Necklaces n=3, k=2 → " + countNecklaces(3, 2)); // 4
        System.out.println("Necklaces n=4, k=3 → " + countNecklaces(4, 3)); // 21
    }
}
