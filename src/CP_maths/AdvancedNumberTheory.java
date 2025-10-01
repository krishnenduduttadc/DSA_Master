package CP_maths;

import java.math.BigInteger;
import java.util.*;

/*
===========================================================================
  AdvancedNumberTheory.java
  -----------------------------------------
  Packed advanced number-theory utilities for Competitive Programming.

  Contents (theory + reusable code):
   - Fast modular arithmetic helpers (mulMod, powMod)
   - Miller-Rabin primality test (deterministic for 64-bit)
   - Pollard-Rho prime factorization (randomized, practical)
   - Prime factorization -> Map<prime, exponent>
   - Get all divisors from factorization
   - Euler's totient via factorization
   - Möbius function sieve (mu) & totient sieve up to N
   - Primitive root (generator) for prime p
   - multiplicative function helpers (sigma, number of divisors)
   - Example usages in main()

  WHY these are important:
   - Miller-Rabin: fast primality check for big inputs (pseudoprime-resistant)
   - Pollard-Rho: factor large composite numbers quickly
   - Primitive root: necessary for NTT, discrete logarithm problems
   - Möbius & totient sieves: multiplicative-number-theory common in problems
   - These routines let you solve many CP problems: factorization tasks,
     solving congruences, computing multiplicative sums, primitive roots, etc.

  WARNING / PRACTICAL NOTES:
   - Pollard-Rho is randomized; repeat attempts if you get stuck on trivial factors.
   - For very large >64-bit integers use BigInteger-based specialized libs.
===========================================================================
*/

public class AdvancedNumberTheory {

    // ----------------------------
    // Modular arithmetic helpers
    // ----------------------------

    // ----------------------------
    // Miller-Rabin primality (deterministic for 64-bit)
    // ----------------------------
    /*
      Theory:
       - Miller-Rabin is a probabilistic primality test.
       - For 64-bit integers, testing with a specific set of bases is deterministic.
       - We use the known base set: {2,325,9375,28178,450775,9780504,1795265022}
         which correctly determines primality for n < 2^64.
    */
    static final long[] MR_TEST_BASES = {2L, 325L, 9375L, 28178L, 450775L, 9780504L, 1795265022L};
    static final Random RAND = new Random();

    // modular multiplication for long avoiding overflow using BigInteger
    // returns (a * b) % mod
    static long mulMod(long a, long b, long mod) {
        // Use BigInteger when product may overflow 64-bit
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }

    // modular exponentiation: a^e % mod (works for long mod)
    static long powMod(long a, long e, long mod) {
        long res = 1 % mod;
        a %= mod;
        while (e > 0) {
            if ((e & 1) == 1) res = mulMod(res, a, mod);
            a = mulMod(a, a, mod);
            e >>= 1;
        }
        return res;
    }

    // ----------------------------
    // Pollard-Rho factorization
    // ----------------------------
    /*
      Theory:
       - Pollard-Rho is a randomized algorithm to find a non-trivial factor of composite n.
       - It uses a polynomial (typically f(x) = x^2 + c) modulo n and Floyd's cycle detection.
       - After finding a factor, recursively factor the factors.
       - Performance is good for 64-bit integers in CP.
    */

    static boolean isPrimeDet(long n) {
        if (n < 2) return false;
        int smallPrimes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (int p : smallPrimes) {
            if (n == p) return true;
            if (n % p == 0) return n == p;
        }
        long d = n - 1;
        int s = 0;
        while ((d & 1) == 0) {
            d >>= 1;
            s++;
        }
        for (long a : MR_TEST_BASES) {
            if (a % n == 0) continue; // base equals n
            long x = powMod(a, d, n);
            if (x == 1 || x == n - 1) continue;
            boolean composite = true;
            for (int r = 1; r < s; r++) {
                x = mulMod(x, x, n);
                if (x == n - 1) {
                    composite = false;
                    break;
                }
            }
            if (composite) return false;
        }
        return true;
    }

    // attempt to find a factor of n (non-trivial) using Pollard Rho
    static long pollardsRhoOne(long n) {
        if ((n & 1) == 0) return 2;
        if (n % 3 == 0) return 3;
        long c = Math.abs(RAND.nextLong()) % (n - 1) + 1; // c in [1..n-1]
        long x = Math.abs(RAND.nextLong()) % n;
        long y = x;
        long d = 1;
        while (d == 1) {
            x = (mulMod(x, x, n) + c) % n;
            y = (mulMod(y, y, n) + c) % n;
            y = (mulMod(y, y, n) + c) % n;
            long diff = x > y ? x - y : y - x;
            d = BigInteger.valueOf(diff).gcd(BigInteger.valueOf(n)).longValue();
            if (d == n) return pollardsRhoOne(n); // retry with different params
        }
        return d;
    }

    // full factorization using Pollard Rho with recursion
    static void factorRho(long n, Map<Long, Integer> out) {
        if (n == 1) return;
        if (isPrimeDet(n)) {
            out.put(n, out.getOrDefault(n, 0) + 1);
            return;
        }
        long d = pollardsRhoOne(n);
        while (d == n) d = pollardsRhoOne(n);
        factorRho(d, out);
        factorRho(n / d, out);
    }

    // convenience wrapper: returns sorted prime factorization map
    public static Map<Long, Integer> factor(long n) {
        Map<Long, Integer> map = new TreeMap<>();
        if (n <= 0) return map;
        factorRho(n, map);
        return map;
    }

    // ----------------------------
    // Divisors from factorization
    // ----------------------------
    // Generate all divisors from prime factorization (recursive)
    static List<Long> getDivisorsFromFactorMap(Map<Long, Integer> factors) {
        List<Long> divisors = new ArrayList<>();
        List<Map.Entry<Long, Integer>> entries = new ArrayList<>(factors.entrySet());
        buildDivisors(entries, 0, 1L, divisors);
        Collections.sort(divisors);
        return divisors;
    }

    static void buildDivisors(List<Map.Entry<Long, Integer>> entries, int idx, long cur, List<Long> out) {
        if (idx == entries.size()) {
            out.add(cur);
            return;
        }
        Map.Entry<Long, Integer> e = entries.get(idx);
        long p = e.getKey();
        int exp = e.getValue();
        long val = cur;
        for (int k = 0; k <= exp; k++) {
            buildDivisors(entries, idx + 1, val, out);
            val = val * p;
        }
    }

    // ----------------------------
    // Euler's totient from factorization
    // ----------------------------
    static long phiFromFactorMap(Map<Long, Integer> factors) {
        long res = 1;
        for (Map.Entry<Long, Integer> e : factors.entrySet()) {
            long p = e.getKey();
            int a = e.getValue();
            long term = 1;
            for (int i = 0; i < a; i++) term *= p;
            // p^a - p^(a-1) = p^(a-1) * (p-1)
            res *= (term / p) * (p - 1);
        }
        return res;
    }

    // linear sieve for phi and mu up to N
    public static SieveResult linearSievePhiMu(int N) {
        SieveResult sr = new SieveResult(N);
        int[] phi = sr.phi;
        int[] mu = sr.mu;
        boolean[] isPrime = sr.isPrime;
        List<Integer> primes = sr.primes;

        phi[0] = 0;
        phi[1] = 1;
        mu[0] = 0;
        mu[1] = 1;
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
                phi[i] = i - 1;
                mu[i] = -1;
            }
            for (int p : primes) {
                long v = 1L * p * i;
                if (v > N) break;
                isPrime[(int) v] = false;
                if (i % p == 0) {
                    phi[(int) v] = phi[i] * p;
                    mu[(int) v] = 0;
                    break;
                } else {
                    phi[(int) v] = phi[i] * (p - 1);
                    mu[(int) v] = -mu[i];
                }
            }
        }
        return sr;
    }

    // ----------------------------
    // Primitive root for prime p
    // ----------------------------
    /*
      Theory:
       - A primitive root g modulo prime p is a generator of the multiplicative
         group modulo p, i.e., its powers produce all residues 1..p-1.
       - g is primitive if for every prime factor q of p-1: g^{(p-1)/q} != 1 (mod p)
    */
    static long primitiveRoot(long p) {
        if (p == 2) return 1;
        long phi = p - 1;
        Map<Long, Integer> fac = factor(phi);
        List<Long> factors = new ArrayList<>(fac.keySet());
        for (long g = 2; g <= p - 1; g++) {
            boolean ok = true;
            for (long q : factors) {
                if (powMod(g, phi / q, p) == 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) return g;
        }
        return -1;
    }

    // ----------------------------
    // Multiplicative function helpers (sigma, tau)
    // ----------------------------
    // number of divisors tau(n) and sum of divisors sigma(n) from factor map
    static long tauFromFactorMap(Map<Long, Integer> fac) {
        long res = 1;
        for (int e : fac.values()) res *= (e + 1);
        return res;
    }

    static long sigmaFromFactorMap(Map<Long, Integer> fac) {
        long res = 1;
        for (Map.Entry<Long, Integer> en : fac.entrySet()) {
            long p = en.getKey();
            int a = en.getValue();
            // sum = (p^(a+1)-1)/(p-1)
            long num = 1;
            for (int i = 0; i <= a; i++) num *= p;
            long sum = (num - 1) / (p - 1);
            res *= sum;
        }
        return res;
    }

    // ----------------------------
    // Discrete order: smallest t>0 s.t. a^t ≡ 1 (mod m), when gcd(a,m)=1
    // ----------------------------
    static long multiplicativeOrder(long a, long m) {
        if (gcd(a, m) != 1) return -1;
        long phi = phiFromFactorMap(factor(m));
        // factor phi to check divisors
        Map<Long, Integer> fac = factor(phi);
        List<Long> divs = getDivisorsFromFactorMap(fac);
        Collections.sort(divs);
        for (long d : divs) {
            if (powMod(a, d, m) == 1) return d;
        }
        return -1;
    }

    // gcd helper
    static long gcd(long a, long b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    // ----------------------------
    // Examples and small tests
    // ----------------------------
    public static void main(String[] args) {
        System.out.println("=== Advanced Number Theory examples ===");

        // ---- primality test ----
        long[] tests = {2L, 3L, 4L, 17L, 561L, 1_000_000_007L, 1_000_000_009L};
        for (long x : tests) {
            System.out.printf("isPrime(%d) = %b%n", x, isPrimeDet(x));
        }

        // ---- factorization ----
        long n = 600851475143L; // big composite (Project Euler famous)
        System.out.println("\nFactorization of " + n + ":");
        Map<Long, Integer> fac = factor(n);
        System.out.println(fac);

        // ---- divisors, phi, tau, sigma ----
        long m = 360L;
        Map<Long, Integer> facm = factor(m);
        System.out.println("\nFactors of " + m + " = " + facm);
        System.out.println("Divisors: " + getDivisorsFromFactorMap(facm));
        System.out.println("phi(" + m + ") = " + phiFromFactorMap(facm));
        System.out.println("numDivisors tau(" + m + ") = " + tauFromFactorMap(facm));
        System.out.println("sumDivisors sigma(" + m + ") = " + sigmaFromFactorMap(facm));

        // ---- primitive root for prime ----
        long p = 1_000_000_007L;
        System.out.println("\nPrimitive root for " + p + " (may take a bit):");
        long g = primitiveRoot(p);
        System.out.println("primitive root = " + g + " (verify g^((p-1)/2) != 1 mod p? -> " +
                (powMod(g, (p - 1) / 2, p) != 1) + ")");

        // ---- linear sieve phi/mu up to N ----
        int N = 50;
        SieveResult sr = linearSievePhiMu(N);
        System.out.println("\nphi[1.." + N + "]: " + Arrays.toString(Arrays.copyOf(sr.phi, 21)));
        System.out.println("mu[1.." + N + "]: " + Arrays.toString(Arrays.copyOf(sr.mu, 21)));

        // ---- multiplicative order example ----
        System.out.println("\nOrder of 2 mod 7: " + multiplicativeOrder(2, 7)); // 3, since 2^3=8≡1 mod7
    }

    // ----------------------------
    // Möbius and totient sieve up to N
    // ----------------------------
    /*
      - Möbius function mu(n):
        mu(1)=1
        mu(n)=0 if n has squared prime factor
        mu(n)=(-1)^k if n is product of k distinct primes
      - We can compute mu[] and phi[] in O(N) using sieve (linear sieve).
    */
    static class SieveResult {
        int N;
        int[] phi;
        int[] mu;
        boolean[] isPrime;
        List<Integer> primes;

        SieveResult(int N) {
            this.N = N;
            phi = new int[N + 1];
            mu = new int[N + 1];
            isPrime = new boolean[N + 1];
            primes = new ArrayList<>();
        }
    }
}
