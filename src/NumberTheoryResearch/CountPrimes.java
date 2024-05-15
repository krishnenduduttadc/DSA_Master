package NumberTheoryResearch;

public class CountPrimes {
    public static void main(String[] args) {
        int upperLimit = (int) 1e6;
        int numberOfPrimes = countPrimesUpTo(upperLimit);

        System.out.println("Number of primes between 1 and " + upperLimit + " (inclusive): " + numberOfPrimes);
    }

    // Function to count the number of prime numbers up to a given upper limit
    public static int countPrimesUpTo(int n) {
        if (n < 2) {
            return 0; // No primes less than 2
        }

        // Estimate number of primes using n/log(n) (Prime Number Theorem approximation)
        double estimatedPrimes = n / Math.log(n);

        // We can use Math.floor to round down the estimated number of primes to an integer
        return (int) Math.floor(estimatedPrimes);
    }
}
