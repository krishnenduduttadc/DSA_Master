package CP_maths;

/*
===============================================================
    FAST EXPONENTIATION (Binary Exponentiation / Fast Power)
    ===============================================================

    ⚡ Why important in CP?
    - Many problems need to compute a^b where:
        * a, b can be huge (up to 10^18)
        * Direct multiplication is too slow
    - Also needed for:
        * Modular exponentiation
        * Modular inverse (Fermat’s theorem)
        * Fast Fibonacci (via matrix exponentiation)
        * Solving recurrences

    ---------------------------------------------------------------
    1. Naive exponentiation:
       a^b = multiply a, b times
       Time complexity: O(b) ❌ (too slow when b ~ 10^9)

    ---------------------------------------------------------------
    2. Binary Exponentiation Idea:
       - Use properties:
            a^b =
               (a^(b/2))^2    if b is even
               a * a^(b-1)    if b is odd
       - This reduces time to O(log b)

       Example: 3^13
            13 in binary = 1101
            3^13 = 3^(8+4+1) = 3^8 * 3^4 * 3^1

    ---------------------------------------------------------------
    3. Modular Exponentiation:
       - Compute a^b % MOD efficiently
       - Prevents overflow and fits within limits
       - Formula:
            res = 1
            while b > 0:
                if (b odd) res = (res * a) % MOD
                a = (a * a) % MOD
                b /= 2

    ---------------------------------------------------------------
    4. Applications:
       - Modular inverse: a^(MOD-2) % MOD
       - Fast Fibonacci (matrix exponentiation uses same trick)
       - Cryptography (RSA)
       - Counting problems (2^n % MOD etc.)

===============================================================
*/

class FastExponentiation {
    static final long MOD = 1000000007;

    // Standard binary exponentiation (without mod)
    static long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    // Modular exponentiation (a^b % MOD)
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

    // Modular inverse using Fermat’s theorem (mod must be prime)
    static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    // Fast Fibonacci using matrix exponentiation (O(log n))
    // [ F(n+1) F(n)   ] = [1 1]^n
    // [ F(n)   F(n-1) ]   [1 0]
    static long fib(long n) {
        if (n == 0) return 0;
        long[][] F = {{1, 1}, {1, 0}};
        powerMatrix(F, n - 1);
        return F[0][0];
    }

    // Matrix multiplication under mod
    static void multiply(long[][] A, long[][] B) {
        long x = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD;
        long y = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD;
        long z = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD;
        long w = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD;

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }

    // Fast power for 2x2 matrix
    static void powerMatrix(long[][] F, long n) {
        if (n == 0 || n == 1) return;
        long[][] M = {{1, 1}, {1, 0}};
        powerMatrix(F, n / 2);
        multiply(F, F);
        if ((n & 1) == 1) multiply(F, M);
    }

    public static void main(String[] args) {
        // 1. Normal fast power
        System.out.println("3^13 = " + power(3, 13));

        // 2. Modular exponentiation
        System.out.println("3^13 % MOD = " + modPow(3, 13, MOD));

        // 3. Modular inverse
        System.out.println("Inverse of 3 mod MOD = " + modInverse(3, MOD));

        // 4. Fibonacci using matrix exponentiation
        System.out.println("Fibonacci(10) = " + fib(10)); // Expected 55
        System.out.println("Fibonacci(50) = " + fib(50)); // Expected 12586269025 % MOD
    }
}

/*
===============================================================
⚡ Key Takeaways:
- Binary exponentiation reduces power calculation to O(log b)
- Always use modular exponentiation in contests to avoid overflow
- Modular inverse = a^(MOD-2) % MOD (if MOD is prime)
- Matrix exponentiation allows O(log n) Fibonacci and linear recurrences
===============================================================
*/

