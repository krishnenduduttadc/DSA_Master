package CP_maths;


class Bracelets {
    /*
    ===============================================================
        Counting Bracelets (Rotations + Reflections)
    ===============================================================

    Formula:
      Bracelets(n,k) = (1 / 2n) * ( Σ k^gcd(n,r) + reflection_sum )

    Reflection cases:
      - n odd  → reflection_sum = n * k^((n+1)/2)
      - n even → reflection_sum = (n/2) * (k^(n/2+1) + k^(n/2))

    Example:
      n=3, k=2
        Rotations: r=0 → 2^3=8
                   r=1 → 2^gcd(3,1)=2
                   r=2 → 2^gcd(3,2)=2
                   sum = 12
        Reflections: odd → 3 * 2^2 = 12
        Total = (12 + 12) / (2*3) = 24/6 = 4

      So 4 distinct bracelets.
    ===============================================================
    */

    static final long MOD = 1000000007;

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

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long countBracelets(int n, int k) {
        long sum = 0;
        // rotations
        for (int r = 0; r < n; r++) {
            sum = (sum + modPow(k, gcd(n, r))) % MOD;
        }

        // reflections
        long refl = 0;
        if (n % 2 == 1) {
            refl = (n * modPow(k, (n + 1) / 2)) % MOD;
        } else {
            refl = ((n / 2) * (modPow(k, n / 2 + 1) + modPow(k, n / 2))) % MOD;
        }

        long total = (sum + refl) % MOD;
        long inv = modPow(2L * n % MOD, MOD - 2);
        return (total * inv) % MOD;
    }

    public static void main(String[] args) {
        System.out.println("Bracelets n=3, k=2 → " + countBracelets(3, 2)); // 4
        System.out.println("Bracelets n=4, k=3 → " + countBracelets(4, 3)); // 21
        System.out.println("Bracelets n=5, k=2 → " + countBracelets(5, 2)); // 8
    }
}

