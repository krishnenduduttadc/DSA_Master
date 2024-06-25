package NumberTheoryL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 50; // Define the limit to find primes up to 100
        List<Integer> primes = sieveOfEratosthenes(n);

        System.out.println("Prime numbers up to " + n + ":");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }

    // Function to implement the Sieve of Eratosthenes algorithm
    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially

        List<Integer> primes = new ArrayList<>();

        // 0 and 1 are not prime numbers
        if (n >= 2) {
            isPrime[0] = isPrime[1] = false;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i); // i is a prime number

                // Mark all multiples of i as non-prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return primes;
    }
}
