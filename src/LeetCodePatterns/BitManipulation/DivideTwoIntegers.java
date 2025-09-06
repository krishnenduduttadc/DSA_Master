package LeetCodePatterns.BitManipulation;

public class DivideTwoIntegers {
    // Main method to test the program
    public static void main(String[] args) {
        DivideTwoIntegers solver = new DivideTwoIntegers();

        System.out.println("10 / 3 = " + solver.divide(10, 3));   // Expected 3
        System.out.println("7 / -3 = " + solver.divide(7, -3));   // Expected -2
        System.out.println("-15 / 2 = " + solver.divide(-15, 2)); // Expected -7
        System.out.println("-2147483648 / -1 = " + solver.divide(-2147483648, -1)); // Expected 2147483647 (overflow handled)
        System.out.println("1 / 1 = " + solver.divide(1, 1));     // Expected 1
    }

    public int divide(int dividend, int divisor) {
        if (dividend == -(1 << 31) && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case
        }

        boolean isPositive = ((dividend > 0 && divisor > 0)
                || (dividend < 0 && divisor < 0));

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int quotient = 0;

        if (a == b) {
            return isPositive ? 1 : -1;
        }

        while (a >= b) {
            int i = 0;
            while ((b << i) <= a) {
                i++;
            }

            quotient += (1 << (i - 1));
            a -= (b << (i - 1));
        }

        return isPositive ? quotient : -quotient;
    }
}
