package LeetCodePatterns.BitManipulation;

public class Sumof2Integers {

    // Main method to test the program
    public static void main(String[] args) {
        Sumof2Integers solver = new Sumof2Integers();

        System.out.println("5 + 3 = " + solver.getSum(5, 3));     // Expected 8
        System.out.println("2 + -3 = " + solver.getSum(2, -3));   // Expected -1
        System.out.println("-7 + -8 = " + solver.getSum(-7, -8)); // Expected -15
        System.out.println("0 + 0 = " + solver.getSum(0, 0));     // Expected 0
        System.out.println("100 + 200 = " + solver.getSum(100, 200)); // Expected 300
    }

    public int getSum(int a, int b) {
        int carry = 0;
        while (b != 0) {
            int sumWithoutCarry = a ^ b;   // XOR for sum without carry
            carry = (a & b) << 1;          // AND + shift for carry
            b = carry;
            a = sumWithoutCarry;
        }
        return a;
    }
}
