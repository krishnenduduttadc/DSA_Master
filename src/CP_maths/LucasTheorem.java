package CP_maths;

/*
===============================================================
    LUCAS’ THEOREM (nCr % p for large n)
    ===============================================================

    ⚡ Problem:
    - Standard factorial precomputation works only up to ~10^6.
    - But what if n = 10^18 and r = 10^9?
    - Direct precomputation impossible.

    ---------------------------------------------------------------
    1. Lucas’ Theorem:
       If p is a prime:
         nCr % p = Π (n_iCr_i % p)
       where n_i, r_i are digits of n and r in base p.

       Example:
         n = 10, r = 3, p = 5
         n = (2,0) base 5 → [n1=2, n0=0]
         r = (0,3) base 5 → [r1=0, r0=3]
         nCr % 5 = C(2,0) * C(0,3) % 5
                 = 1 * 0 = 0

    ---------------------------------------------------------------
    2. Steps:
       - Convert n, r to base p
       - Compute n_iCr_i for each digit using precomputed factorials up to p-1
       - Multiply results modulo p

    ---------------------------------------------------------------
    3. Complexity:
       - O(log_p(n))
       - Precomputation: factorials up to p-1

    ---------------------------------------------------------------
    4. Applications:
       - n and r as large as 10^18
       - CP problems with prime modulus and huge values
===============================================================
*/

class LucasTheorem {
    static int MOD; // must be prime
    static long[] fact;
    static long[] invFact;

    // Modular exponentiation
    static long modPow(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    // Precompute factorials up to MOD-1
    static void precompute(int p) {
        MOD = p;
        fact = new long[p];
        invFact = new long[p];
        fact[0] = 1;
        for (int i = 1; i < p; i++) fact[i] = (fact[i - 1] * i) % p;
        invFact[p - 1] = modPow(fact[p - 1], p - 2, p); // Fermat
        for (int i = p - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % p;
        }
    }

    // nCr % MOD when n,r < MOD
    static long nCrSmall(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    // Lucas theorem: nCr % MOD for large n
    static long nCrLucas(long n, long r) {
        if (r == 0) return 1;
        int ni = (int) (n % MOD);
        int ri = (int) (r % MOD);
        return (nCrLucas(n / MOD, r / MOD) * nCrSmall(ni, ri)) % MOD;
    }

    public static void main(String[] args) {
        // Example with prime modulus
        int p = 7;
        precompute(p);

        System.out.println("C(10, 3) % 7 = " + nCrLucas(10, 3)); // Expected 1
        System.out.println("C(1000, 300) % 7 = " + nCrLucas(1000, 300));
        System.out.println("C(1000000000000, 12345) % 7 = " + nCrLucas(1000000000000L, 12345L));
    }
}

/*
===============================================================
⚡ Key Takeaways:
- Lucas theorem reduces large nCr to digit-wise computation in base p
- Works only when modulus p is prime
- Very efficient: O(log_p(n))
===============================================================
*/

