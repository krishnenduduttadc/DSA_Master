package NumberTheoryResearch;

public class SumOfFactors {
    public static void main(String[] args) {
        int number = 84;
        int sumOfFactors = 0;

        System.out.println("Factors of " + number + " are:");

        // Find factors and calculate sum
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
                sumOfFactors += i; // Add factor to the sum
            }
        }

        System.out.println("Sum of factors of " + number + " = " + sumOfFactors);
    }
}
