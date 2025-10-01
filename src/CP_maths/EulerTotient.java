package CP_maths;

/*
===============================================================
    EULER'S TOTIENT FUNCTION φ(n)
    ===============================================================

    ⚡ Definition:
    - φ(n) = count of integers in [1..n] that are coprime with n.
    - Example:
        n=9 → numbers = {1,2,4,5,7,8} → φ(9)=6

    ---------------------------------------------------------------
    1. Properties:
       - If p is prime:
            φ(p) = p-1
       - If n = p^k (prime power):
            φ(n) = p^k - p^(k-1) = p^k * (1 - 1/p)
       - General formula (prime factorization):
            φ(n) = n * Π (1 - 1/p)   for all distinct primes p dividing n

    ---------------------------------------------------------------
    2. Important Identities:
       - Sum over divisors:
            Σ φ(d) = n   (for all d | n)
       - φ is multiplicative:
            if gcd(a, b)=1 → φ(a*b) = φ(a)*φ(b)

    ---------------------------------------------------------------
    3. Applications in CP:
       - Modular Inverses (Euler’s theorem):
            If gcd(a,n)=1:
                a^(φ(n)) ≡ 1 (mod n)
            → a^(φ(n)-1) ≡ a^(-1) (mod n)
       - RSA encryption/decryption
       - Reducing large powers in modular exponentiation

    ---------------------------------------------------------------
    4. Computation:
       - Naive: check gcd for all numbers up to n → O(n log n)
       - Efficient: use prime factorization → O(√n)
       - Precompute for all n ≤ N with a sieve (Euler’s sieve)

===============================================================
*/

import java.util.Arrays;

class EulerTotient {
    // Efficient φ(n) using prime factorization
    static long phi(long n) {
        long result = n;
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) n /= p;
                result -= result / p;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }

    // Precompute φ for all numbers [1..N] using sieve
    static int[] phiSieve(int N) {
        int[] phi = new int[N + 1];
        for (int i = 0; i <= N; i++) phi[i] = i;

        for (int p = 2; p <= N; p++) {
            if (phi[p] == p) { // p is prime
                for (int k = p; k <= N; k += p) {
                    phi[k] -= phi[k] / p;
                }
            }
        }
        return phi;
    }

    public static void main(String[] args) {
        // Single number example
        System.out.println("phi(9) = " + phi(9)); // Expected 6
        System.out.println("phi(36) = " + phi(36)); // Expected 12

        // Precompute φ for 1..20
        int[] pre = phiSieve(20);
        System.out.println("phi(1..20) = " + Arrays.toString(pre));

        // Application: Modular inverse using Euler's theorem
        // For n=10, gcd(3,10)=1 → 3^(phi(10)-1) mod 10 = inverse of 3
        long n = 10;
        long a = 3;
        long inv = modPow(a, phi(n) - 1, n); // only valid if gcd(a,n)=1
        System.out.println("Inverse of " + a + " mod " + n + " = " + inv);
    }

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
}

/*
===============================================================
⚡ Key Takeaways:
- φ(n) counts numbers ≤ n coprime to n
- Formula: φ(n) = n * Π(1 - 1/p) for prime divisors p
- Use sieve to compute φ for all numbers in O(n log log n)
- Euler’s theorem: a^φ(n) ≡ 1 (mod n) when gcd(a,n)=1
- Used in modular inverse and RSA
===============================================================
*/

