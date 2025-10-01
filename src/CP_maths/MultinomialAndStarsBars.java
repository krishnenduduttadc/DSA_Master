package CP_maths;

/*
===============================================================
    MULTINOMIAL COEFFICIENTS & STARS AND BARS
    ===============================================================

    ---------------------------------------------------------------
    1. Multinomial Coefficient
    ---------------------------------------------------------------
    Generalization of nCr:
        - Number of ways to divide n objects into k groups of sizes
          (n1, n2, ..., nk) such that sum(ni) = n.
        - Formula:
              n! / (n1! * n2! * ... * nk!)

    Example:
        Arrange letters of "BANANA":
        Counts = {B=1, A=3, N=2}
        Ways = 6! / (1! * 3! * 2!) = 60

    Implementation:
        - Same as nCr logic but extended to multiple groups
        - Precompute factorial[] and invFact[]

    ---------------------------------------------------------------
    2. Stars and Bars (a.k.a Balls and Bins)
    ---------------------------------------------------------------
    Problem:
        - Distribute n identical balls into k distinct boxes
        - Formula (non-negative integer solutions of x1+x2+...+xk=n):
              C(n+k-1, k-1)

    Variants:
        (a) Each box must have >= 0 balls → C(n+k-1, k-1)
        (b) Each box must have >= 1 ball → C(n-1, k-1)

    Example:
        Distribute 7 candies into 3 kids:
        Ways = C(7+3-1, 3-1) = C(9,2) = 36

    ---------------------------------------------------------------
    3. Applications:
        - Partitioning problems
        - Probability problems (balls and bins)
        - Arranging objects with repetitions
===============================================================
*/

class MultinomialAndStarsBars {
    static final int MOD = 1000000007;
    static final int MAXN = 1000000;

    static long[] fact = new long[MAXN + 1];
    static long[] invFact = new long[MAXN + 1];

    // Fast power
    static long modPow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    // Precompute factorials
    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i <= MAXN; i++) fact[i] = (fact[i - 1] * i) % MOD;
        invFact[MAXN] = modPow(fact[MAXN], MOD - 2, MOD);
        for (int i = MAXN - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    // Multinomial coefficient n! / (n1! * n2! * ... * nk!)
    static long multinomial(int[] counts) {
        int n = 0;
        for (int c : counts) n += c;
        long res = fact[n];
        for (int c : counts) {
            res = (res * invFact[c]) % MOD;
        }
        return res;
    }

    // Stars and bars: distribute n balls into k bins
    static long starsAndBars(int n, int k, boolean atLeastOne) {
        if (atLeastOne) {
            return nCr(n - 1, k - 1);
        } else {
            return nCr(n + k - 1, k - 1);
        }
    }

    public static void main(String[] args) {
        precompute();

        // Multinomial example
        int[] counts = {1, 3, 2}; // BANANA letters: B=1,A=3,N=2
        System.out.println("Ways to arrange BANANA = " + multinomial(counts));

        // Stars and bars examples
        System.out.println("Distribute 7 candies into 3 kids (≥0 each) = " +
                starsAndBars(7, 3, false)); // Expected 36
        System.out.println("Distribute 7 candies into 3 kids (≥1 each) = " +
                starsAndBars(7, 3, true));  // Expected 15
    }
}

/*
===============================================================
⚡ Key Takeaways:
- Multinomial coefficient = generalization of nCr
- Stars & Bars = formula for distributing identical objects into bins
- Formula:
    ≥0 balls → C(n+k-1, k-1)
    ≥1 ball  → C(n-1, k-1)
===============================================================
*/

