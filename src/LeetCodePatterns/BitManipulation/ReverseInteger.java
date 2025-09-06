package LeetCodePatterns.BitManipulation;

public class ReverseInteger {

    // Main method to test the program
    public static void main(String[] args) {
        ReverseInteger solver = new ReverseInteger();

        System.out.println("Reverse of 123 = " + solver.reverse(123));       // Expected 321
        System.out.println("Reverse of -123 = " + solver.reverse(-123));     // Expected -321
        System.out.println("Reverse of 120 = " + solver.reverse(120));       // Expected 21
        System.out.println("Reverse of 0 = " + solver.reverse(0));           // Expected 0
        System.out.println("Reverse of 1534236469 = " + solver.reverse(1534236469)); // Expected 0 (overflow)
    }

    public int reverse(int x) {
        int reversedNum = 0;

        while (x != 0) {
            int digit = x % 10;
            int newReversedNum = reversedNum * 10 + digit;

            // Check for overflow
            if ((newReversedNum - digit) / 10 != reversedNum) {
                return 0;
            }

            reversedNum = newReversedNum;
            x /= 10;
        }

        return reversedNum;
    }
}
