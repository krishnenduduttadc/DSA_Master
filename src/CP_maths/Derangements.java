package CP_maths;

/*
===============================================================
    DERANGEMENTS (!n)
    ===============================================================

    ⚡ Problem:
    - Count permutations of n elements with NO fixed points
      (i.e., for all i, perm[i] ≠ i).
    - Example: For n=3 → permutations = [231, 312] → count = 2

    ---------------------------------------------------------------
    1. Formula from Inclusion–Exclusion:
       !n = n! * (1 - 1/1! + 1/2! - 1/3! + ... + (-1)^n / n!)

    ---------------------------------------------------------------
    2. Recurrence Relation:
       !n = (n-1) * (!(n-1) + !(n-2))
       Base cases: !0 = 1, !1 = 0

    ---------------------------------------------------------------
    3. Approximation:
       !n ≈ n! / e  (rounded to nearest integer)

    ---------------------------------------------------------------
    4. Applications:
       - Probability: chance that no one gets their own gift (Secret Santa)
         → ≈ 1/e ≈ 36.7%
       - Problems involving mismatched pairings
===============================================================
*/

class Derangements {
    static final int MOD = 1000000007;
    static final int MAXN = 1000000;

    static long[] fact = new long[MAXN + 1];
    static long[] der = new long[MAXN + 1];

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

    // Precompute factorials and derangements
    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i <= MAXN; i++) fact[i] = (fact[i - 1] * i) % MOD;

        der[0] = 1;
        if (MAXN >= 1) der[1] = 0;
        for (int i = 2; i <= MAXN; i++) {
            der[i] = ((i - 1) * (der[i - 1] + der[i - 2])) % MOD;
        }
    }

    public static void main(String[] args) {
        precompute();

        // Small examples
        System.out.println("!3 = " + der[3]); // Expected 2
        System.out.println("!4 = " + der[4]); // Expected 9

        // Probability that 5 people don't get their own gift
        System.out.println("Probability n=5: " + der[5] + "/" + fact[5]);

        // Large n
        System.out.println("!1000000 mod 1e9+7 = " + der[1000000]);
    }
}

/*
===============================================================
⚡ Key Takeaways:
- Derangements count permutations with no fixed points
- Formula: !n = n! * Σ((-1)^k / k!)
- Recurrence: !n = (n-1)(!(n-1) + !(n-2))
- Probability tends to 1/e (~36.7%)
===============================================================
*/

