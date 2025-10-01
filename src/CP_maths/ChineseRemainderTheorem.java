package CP_maths;

/*
===============================================================
    CHINESE REMAINDER THEOREM (CRT)
    ===============================================================

    ⚡ Problem Statement:
    Solve system of modular equations:
        x ≡ a1 (mod m1)
        x ≡ a2 (mod m2)
        ...
        x ≡ ak (mod mk)

    ---------------------------------------------------------------
    1. Special Case: Two equations, coprime moduli
       If gcd(m1, m2) = 1:
           - Unique solution exists modulo (m1*m2)
           - Constructive method:
                x = a1 + m1 * ( (a2 - a1) * inv(m1, m2) mod m2 )

       Example:
         x ≡ 2 (mod 3)
         x ≡ 3 (mod 5)
         → Solution x = 8 (mod 15)

    ---------------------------------------------------------------
    2. General Case: Multiple pairwise coprime moduli
       Suppose m1, m2, ..., mk are pairwise coprime.
       Then there exists a unique solution modulo M = m1*m2*...*mk.

       Algorithm:
         M = m1*m2*...*mk
         For each i:
            Mi = M / mi
            inv = inverse(Mi, mi)
            contribution = ai * Mi * inv
         Final answer = sum(contributions) mod M

    ---------------------------------------------------------------
    3. General Case (not necessarily coprime moduli)
       Use "Generalized CRT":
         - Solution exists iff ai ≡ aj (mod gcd(mi, mj)) for all i,j
         - Reduce to lcm of moduli step by step
         - Implement via Extended Euclidean Algorithm

    ---------------------------------------------------------------
    4. Applications:
       - Solving modular systems
       - Number theory problems in CP
       - RSA, cryptography
       - Competitive problems like "find x mod m1,m2,..."

===============================================================
*/

class ChineseRemainderTheorem {
    static final long MOD = 1000000007;

    // Extended Euclidean Algorithm
    static long gcdExtended(long a, long b, long[] xy) {
        if (b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }
        long[] xy1 = new long[2];
        long g = gcdExtended(b, a % b, xy1);
        xy[0] = xy1[1];
        xy[1] = xy1[0] - (a / b) * xy1[1];
        return g;
    }

    // Modular inverse of a mod m (assuming gcd(a,m)=1)
    static long modInverse(long a, long m) {
        long[] xy = new long[2];
        long g = gcdExtended(a, m, xy);
        if (g != 1) throw new RuntimeException("Inverse does not exist");
        long res = (xy[0] % m + m) % m;
        return res;
    }

    // CRT for pairwise coprime moduli
    static long crtCoprime(long[] a, long[] m) {
        int k = a.length;
        long M = 1;
        for (long mod : m) M *= mod;

        long res = 0;
        for (int i = 0; i < k; i++) {
            long Mi = M / m[i];
            long inv = modInverse(Mi, m[i]);
            res = (res + a[i] * Mi % M * inv % M) % M;
        }
        return (res + M) % M; // ensure positive
    }

    // General CRT (not necessarily coprime)
    // Returns {x, lcm} meaning solution x mod lcm
    static long[] crtGeneral(long a1, long m1, long a2, long m2) {
        long[] xy = new long[2];
        long g = gcdExtended(m1, m2, xy);
        if ((a2 - a1) % g != 0) return new long[]{-1, -1}; // no solution

        long lcm = m1 / g * m2;
        long x = (a1 + (a2 - a1) / g * xy[0] % (m2 / g) * m1) % lcm;
        if (x < 0) x += lcm;
        return new long[]{x, lcm};
    }

    public static void main(String[] args) {
        // ===== Example 1: Coprime moduli =====
        long[] a = {2, 3, 2};
        long[] m = {3, 5, 7};
        long sol = crtCoprime(a, m);
        System.out.println("Solution of system x≡2(mod3),x≡3(mod5),x≡2(mod7): x = " + sol);

        // ===== Example 2: General CRT (not coprime) =====
        // x ≡ 2 (mod 6), x ≡ 3 (mod 9)
        long[] ans = crtGeneral(2, 6, 3, 9);
        if (ans[0] == -1) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Solution: x ≡ " + ans[0] + " (mod " + ans[1] + ")");
        }
    }
}

/*
===============================================================
⚡ Key Takeaways:
- CRT gives a unique solution modulo product of moduli (if coprime)
- Generalized CRT works for non-coprime moduli if consistency holds
- Requires Extended Euclidean Algorithm for modular inverses
===================

*/