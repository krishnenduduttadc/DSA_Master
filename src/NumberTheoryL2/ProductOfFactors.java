package NumberTheoryL2;

public class ProductOfFactors {

        public static void main(String[] args) {
            int number = 84;
            long productOfFactors = 1; // Start with 1 to accumulate the product

            System.out.println("Factors of " + number + " are:");

            // Find factors and calculate product
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                    productOfFactors *= i; // Multiply factor to the product
                }
            }

            System.out.println("Product of factors of " + number + " = " + productOfFactors);
        }


}
