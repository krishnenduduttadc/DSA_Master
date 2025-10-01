package CP_maths;

/*
===============================================================
    PRIME NUMBERS in COMPETITIVE PROGRAMMING
    ===============================================================
    ⚡ Why primes matter?
    - Basis of number theory
    - Factorization, divisors, modular arithmetic, cryptography
    - Used in Codeforces/CodeChef for:
        * Prime checking
        * Factorization
        * Euler’s Totient
        * Modular inverse (when MOD is prime)
        * Combinatorics nCr % MOD
        * Sieve for precomputations

    ---------------------------------------------------------------
    1. Prime Definition:
       A prime number is a number > 1 that has no divisors other than 1 and itself.
       Examples: 2, 3, 5, 7, 11, ...

    ---------------------------------------------------------------
    2. Naive Prime Check:
       - Check divisibility up to sqrt(n)
       - O(√n)
       - Works for single queries, not for large ranges

    ---------------------------------------------------------------
    3. Sieve of Eratosthenes:
       - Precompute primes up to N in O(N log log N)
       - Steps:
         * Assume all numbers are prime
         * Start from p=2, eliminate all multiples of p
         * Continue until p*p <= N
       - Memory: O(N)
       - Very fast and used widely in CP

    ---------------------------------------------------------------
    4. Prime Factorization:
       - Break number into prime factors
       - Naive: trial division up to √n
       - Optimized: Use sieve primes for factorization

    ---------------------------------------------------------------
    5. Euler’s Totient Function φ(n):
       - φ(n) = count of numbers in [1..n] that are coprime to n
       - Formula:
            if n = p1^a1 * p2^a2 * ... * pk^ak
            => φ(n) = n * (1 - 1/p1) * (1 - 1/p2) * ... * (1 - 1/pk)
       - Example:
            n=12 = 2^2 * 3^1
            φ(12) = 12 * (1-1/2) * (1-1/3) = 12 * 1/2 * 2/3 = 4
            (coprimes: 1, 5, 7, 11)

===============================================================
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrimeNumbers {

    // Naive prime check O(√n)
    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // Sieve of Eratosthenes up to N
    static boolean[] sieve(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= N; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= N; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
        return isPrime;
    }

    // Prime Factorization O(√n)
    static List<Long> primeFactorization(long n) {
        List<Long> factors = new ArrayList<>();
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) factors.add(n); // remaining prime
        return factors;
    }

    // Euler’s Totient Function φ(n) using prime factorization
    static long phi(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                result -= result / i;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }

    public static void main(String[] args) {
        // 1. Prime check
        System.out.println("Is 29 prime? " + isPrime(29));

        // 2. Sieve
        int N = 50;
        boolean[] primes = sieve(N);
        System.out.print("Primes up to " + N + ": ");
        for (int i = 2; i <= N; i++) if (primes[i]) System.out.print(i + " ");
        System.out.println();

        // 3. Factorization
        long num = 84;
        System.out.println("Prime factors of " + num + ": " + primeFactorization(num));

        // 4. Euler’s Totient
        long n = 12;
        System.out.println("φ(" + n + ") = " + phi(n));
    }
}

/*
===============================================================
⚡ Key Takeaways:
- isPrime() O(√n) good for single checks (n up to 10^12 in contests)
- Sieve O(N log log N) is must-have for precomputation
- Factorization with sieve primes is much faster than plain √n
- Euler’s Totient φ(n) is heavily used in:
    * Modular arithmetic (a^φ(m) ≡ 1 mod m)
    * Cryptography (RSA)
    * Counting problems
===============================================================
*/

