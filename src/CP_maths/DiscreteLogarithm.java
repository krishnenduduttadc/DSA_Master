package CP_maths;

import java.util.HashMap;
import java.util.Map;

class DiscreteLogarithm {
    /*
    ===============================================================
        Discrete Logarithm (Baby-Step Giant-Step Algorithm)
    ===============================================================

    Solve for x in:
        a^x ≡ b (mod m)

    Complexity: O(√m)
    ===============================================================
    */

    static long modPow(long a, long e, long m) {
        long res = 1 % m;
        a %= m;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % m;
            a = (a * a) % m;
            e >>= 1;
        }
        return res;
    }

    static long modInverse(long a, long m) {
        // works if m is prime
        return modPow(a, m - 2, m);
    }

    static long BSGS(long a, long b, long m) {
        a %= m;
        b %= m;
        if (b == 1) return 0;

        long n = (long) Math.ceil(Math.sqrt(m));

        // Baby steps
        Map<Long, Long> baby = new HashMap<>();
        long cur = 1;
        for (long j = 0; j < n; j++) {
            if (!baby.containsKey(cur)) baby.put(cur, j);
            cur = (cur * a) % m;
        }

        // a^-n
        long an = modPow(a, n * (m - 2) % (m - 1), m);

        // Giant steps
        cur = b;
        for (long i = 0; i <= n; i++) {
            if (baby.containsKey(cur)) {
                return i * n + baby.get(cur);
            }
            cur = (cur * an) % m;
        }

        return -1; // no solution
    }

    public static void main(String[] args) {
        long a = 5, b = 8, m = 23;
        // Solve 5^x ≡ 8 (mod 23)
        long x = BSGS(a, b, m);
        System.out.println("Solution x = " + x); // Expected: 6, since 5^6=15625 ≡ 8 mod 23
    }
}
