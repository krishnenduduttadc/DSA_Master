package LeetCodePatterns.BitManipulation;

public class Numberof1bits {

    // Main method to test the program
    public static void main(String[] args) {
        Numberof1bits solver = new Numberof1bits();

        int n1 = 11; // Binary: 1011
        System.out.println("Hamming weight of " + n1 + " = " + solver.hammingWeight(n1)); // Expected 3

        int n2 = 128; // Binary: 10000000
        System.out.println("Hamming weight of " + n2 + " = " + solver.hammingWeight(n2)); // Expected 1

        int n3 = 2147483647; // Binary: 31 ones
        System.out.println("Hamming weight of " + n3 + " = " + solver.hammingWeight(n3)); // Expected 31

        int n4 = -3; // In Java, negative numbers are 2's complement
        System.out.println("Hamming weight of " + n4 + " = " + solver.hammingWeight(n4));
    }

    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i <= 31; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }
}
