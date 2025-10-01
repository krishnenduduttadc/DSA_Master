package CP_maths;

/*
===================================================================
    Burnside's Lemma + Polya Enumeration in CP
===================================================================

🔥 Theory Recap:
- When symmetry is involved (rotations, reflections), naive counting overcounts.
- Burnside’s Lemma:
    # distinct colorings = (1/|G|) * Σ Fix(g)

Example:
- Count distinct necklaces with n beads and k colors
- Formula:
    distinct = (1/n) * Σ_{r=0}^{n-1} k^gcd(n, r)

===================================================================
*/

public class BurnsidePolya {
    static final int MOD = 1000000007;

    // Fast exponentiation (a^b % MOD)
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

    // GCD
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Burnside’s Lemma for necklaces
    static long countNecklaces(int n, int k) {
        long sum = 0;
        for (int r = 0; r < n; r++) {
            sum = (sum + modPow(k, gcd(n, r))) % MOD;
        }
        // divide by n under modulo (use modular inverse)
        long invN = modPow(n, MOD - 2);
        return (sum * invN) % MOD;
    }

    // Burnside’s Lemma for bracelets (rotations + reflections)
    static long countBracelets(int n, int k) {
        long sum = 0;
        // Rotations
        for (int r = 0; r < n; r++) {
            sum = (sum + modPow(k, gcd(n, r))) % MOD;
        }
        // Reflections
        if (n % 2 == 0) {
            // Even n: n/2 reflections with k^(n/2+1) and n/2 with k^(n/2)
            sum = (sum + (n / 2) * modPow(k, n / 2 + 1)) % MOD;
            sum = (sum + (n / 2) * modPow(k, n / 2)) % MOD;
        } else {
            // Odd n: n reflections with k^((n+1)/2)
            sum = (sum + n * modPow(k, (n + 1) / 2)) % MOD;
        }
        // divide by 2n
        long inv2n = modPow(2L * n % MOD, MOD - 2);
        return (sum * inv2n) % MOD;
    }

    public static void main(String[] args) {
        int n = 6; // beads
        int k = 3; // colors

        System.out.println("Distinct necklaces (n=" + n + ", k=" + k + "): " + countNecklaces(n, k));
        System.out.println("Distinct bracelets (n=" + n + ", k=" + k + "): " + countBracelets(n, k));

        // Another test
        n = 4;
        k = 2;
        System.out.println("Distinct necklaces (n=" + n + ", k=" + k + "): " + countNecklaces(n, k));
        System.out.println("Distinct bracelets (n=" + n + ", k=" + k + "): " + countBracelets(n, k));
    }
}

/*
===================================================================
⚡ Key Takeaways:
- Burnside’s Lemma counts distinct objects under group actions
- Necklaces (rotations) → (1/n) * Σ k^gcd(n, r)
- Bracelets (rotations + reflections) → extra symmetry terms
- Often appears in CP problems about coloring, tiling, and symmetry
===================================================================
*/

