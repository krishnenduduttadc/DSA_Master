package NumberTheoryL2;

public class PrintPrimeFactors {
    public static void main(String[] args) {
        int number = 84; // Fixed input number

        System.out.print("Prime factors of " + number + " are: ");
        printPrimeFactors(number);
    }

    // Function to print prime factors of a number
    public static void printPrimeFactors(int number) {
        if (number <= 1) {
            System.out.println("No prime factors for numbers less than or equal to 1.");
            return;
        }

        // Check for divisibility with prime numbers up to the square root of 'number'
        for (int i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
        }

        // If the remaining number is greater than 1, it is also a prime factor
        if (number > 1) {
            System.out.print(number);
        }
        System.out.println(); // Move to the next line after printing factors
    }
}
