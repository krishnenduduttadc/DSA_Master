package NumberTheoryResearch;

public class PerfectNumber {
    public static void main(String[] args) {
        int number = 28; // Example number to check

        if (isPerfectNumber(number)) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.println(number + " is not a perfect number.");
        }
    }

    // Function to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        if (number <= 0) {
            return false; // Perfect numbers are positive integers
        }

        int sum = 0;

        // Find all proper divisors and calculate their sum
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        // Check if the sum of divisors equals the original number
        return sum == number;
    }
}
