package CP_maths;

/*
===============================================================
    COMBINATORICS in COMPETITIVE PROGRAMMING
    ===============================================================

    ⚡ Why is this important?
    - Many problems involve counting, arrangements, binomial coefficients
    - Examples:
        * Count ways to choose teams, subsets, paths
        * Count permutations with restrictions
        * Probability problems
        * Dynamic Programming involving nCr
    - ALWAYS combined with modular arithmetic since answers can be huge

    ---------------------------------------------------------------
    1. Factorials
       - n! = n * (n-1) * (n-2) * ... * 1
       - Growth is super fast, so we compute modulo MOD

    ---------------------------------------------------------------
    2. nCr (binomial coefficient)
       - "Choose r elements from n"
       - Formula:
            nCr = n! / (r! * (n-r)!)
       - With modulo:
            nCr % MOD = (fact[n] * invFact[r] % MOD * invFact[n-r] % MOD)

    ---------------------------------------------------------------
    3. nPr (permutations)
       - "Arrange r elements from n"
       - Formula:
            nPr = n! / (n-r)!
       - With modulo:
            nPr % MOD = fact[n] * invFact[n-r] % MOD

    ---------------------------------------------------------------
    4. Modular Inverse in nCr
       - Division under mod is not allowed directly.
       - We use modular inverse:
            a/b mod M = a * b^(M-2) mod M   (if M is prime)
       - Precompute factorials and inverse factorials.

    ---------------------------------------------------------------
    5. Precomputation Trick
       - For constraints like n ≤ 10^6:
         * Precompute fact[i] for i=0..n
         * Precompute invFact[i] using Fermat’s theorem
       - Then each nCr query is O(1)

    ---------------------------------------------------------------
    6. Lucas Theorem (advanced, used if n is very large, >10^7)
       - If MOD is prime:
            nCr(n, r) % MOD = nCr(n/MOD, r/MOD) * nCr(n%MOD, r%MOD) % MOD
       - Used when n, r are huge but MOD is small prime

===============================================================
*/

class Combinatorics {
    static final int MOD = 1000000007; // Large prime
    static final int MAXN = 1000000;   // Precompute up to 1e6

    static long[] fact = new long[MAXN + 1];
    static long[] invFact = new long[MAXN + 1];

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

    // Precompute factorials and inverse factorials
    static void precomputeFactorials() {
        fact[0] = 1;
        for (int i = 1; i <= MAXN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAXN] = modPow(fact[MAXN], MOD - 2); // Fermat inverse
        for (int i = MAXN - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Compute nCr % MOD
    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    // Compute nPr % MOD
    static long nPr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (fact[n] * invFact[n - r]) % MOD;
    }

    // Lucas theorem implementation (recursive)
    static long nCrLucas(long n, long r) {
        if (r == 0) return 1;
        return (nCrLucas(n / MOD, r / MOD) * nCr((int) (n % MOD), (int) (r % MOD))) % MOD;
    }

    public static void main(String[] args) {
        precomputeFactorials();

        // Example 1: Compute 5C2
        System.out.println("5C2 % MOD = " + nCr(5, 2)); // Expected 10

        // Example 2: Compute 10P3
        System.out.println("10P3 % MOD = " + nPr(10, 3)); // Expected 720

        // Example 3: Large nCr with precomputation
        System.out.println("1000000C500000 % MOD = " + nCr(1000000, 500000));

        // Example 4: Lucas theorem (for very large n, r)
        long n = 1000000000000L, r = 500000000000L;
        System.out.println("Lucas theorem nCr(" + n + "," + r + ") % MOD = " + nCrLucas(n, r));
    }
}

/*
===============================================================
⚡ Key Takeaways:
- Always precompute factorials for n up to 1e6 in CP
- nCr and nPr under mod require modular inverse (Fermat’s theorem)
- Lucas theorem is required when n > 1e7 with small MOD
- Time complexity:
    * Precomputation: O(n)
    * Each nCr query: O(1)
===============================================================
*/

