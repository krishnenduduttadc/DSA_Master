package CP_maths;

/*
===============================================================
    MODULAR COMBINATORICS (nCr % MOD)
    ===============================================================

    ⚡ Why important in CP?
    - Problems ask: "How many ways to choose r objects from n?"
    - Formula: nCr = n! / (r! * (n-r)!)
    - Direct computation impossible when n ~ 10^6+ (overflow)
    - Solution: Precompute factorials % MOD + modular inverse

    ---------------------------------------------------------------
    1. Basics:
       - nCr = n! / (r!(n-r)!)
       - Under modulo prime p:
           nCr % p = fact[n] * inv(fact[r]) * inv(fact[n-r]) % p
       - Modular inverse via Fermat’s theorem:
           a^(p-2) ≡ a^(-1) (mod p), if p is prime

    ---------------------------------------------------------------
    2. Precomputation:
       fact[i] = (i * fact[i-1]) % MOD
       invFact[i] = modInverse(fact[i], MOD)
       Complexity: O(n)

    ---------------------------------------------------------------
    3. Computing nCr:
       nCr(n, r) = fact[n] * invFact[r] * invFact[n-r] % MOD

    ---------------------------------------------------------------
    4. Edge cases:
       - r < 0 or r > n → nCr = 0
       - n, r up to 10^6 is standard precomputation limit

    ---------------------------------------------------------------
    5. Extensions:
       - Lucas’ theorem handles n up to 10^18 (later topic)
       - Multinomial coefficients
===============================================================
*/

class ModularCombinatorics {
    static final int MOD = 1000000007;
    static final int MAXN = 1000000; // precompute up to 1e6

    static long[] fact = new long[MAXN + 1];
    static long[] invFact = new long[MAXN + 1];

    // Fast modular exponentiation
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

    // Precompute factorials and inverse factorials
    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i <= MAXN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[MAXN] = modPow(fact[MAXN], MOD - 2, MOD);
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

    public static void main(String[] args) {
        precompute();

        System.out.println("5C2 = " + nCr(5, 2)); // Expected 10
        System.out.println("10C3 = " + nCr(10, 3)); // Expected 120
        System.out.println("10P3 = " + nPr(10, 3)); // Expected 720

        // Large n example
        System.out.println("1000000C500000 mod 1e9+7 = " + nCr(1000000, 500000));
    }
}

/*
===============================================================
⚡ Key Takeaways:
- nCr under mod prime requires factorial + modular inverse
- Precomputation in O(n), each query in O(1)
- Formula: nCr = fact[n] * invFact[r] * invFact[n-r] % MOD
- For n > 1e6 (huge n), use Lucas’ theorem (coming next)
===============================================================
*/

