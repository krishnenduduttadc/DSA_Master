package CP_maths;


class CatalanNumbers {
    /*
    ===============================================================
        Catalan Numbers
    ===============================================================

    Formula:
      C_n = (1/(n+1)) * (2n choose n)

    Recurrence:
      C_0 = 1
      C_{n+1} = Σ C_i * C_{n-i}, i=0..n

    Applications:
      - Valid parentheses strings
      - Binary Search Trees (BSTs)
      - Polygon triangulations
      - Non-crossing partitions
      - Dyck paths

    ===============================================================
    */

    static final long MOD = 1000000007;
    static final int MAXN = 1000000;

    static long[] fact = new long[2 * MAXN + 1];
    static long[] invFact = new long[2 * MAXN + 1];

    // fast power
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

    static long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[fact.length - 1] = modInverse(fact[fact.length - 1]);
        for (int i = fact.length - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    // Catalan using formula
    static long catalan(int n) {
        long res = nCr(2 * n, n);
        res = (res * modInverse(n + 1)) % MOD;
        return res;
    }

    public static void main(String[] args) {
        precompute();

        System.out.println("Catalan(0) = " + catalan(0)); // 1
        System.out.println("Catalan(1) = " + catalan(1)); // 1
        System.out.println("Catalan(3) = " + catalan(3)); // 5
        System.out.println("Catalan(4) = " + catalan(4)); // 14

        // Large n
        System.out.println("Catalan(1000) mod 1e9+7 = " + catalan(1000));
    }
}

