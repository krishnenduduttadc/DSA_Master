package LeetCodePatterns.BitManipulation;

import java.util.Arrays;

public class CountingBits {
    // Main method to test the program
    public static void main(String[] args) {
        CountingBits solver = new CountingBits();

        int n1 = 2;
        System.out.println("Count bits up to " + n1 + ": " + Arrays.toString(solver.countBits(n1)));

        int n2 = 5;
        System.out.println("Count bits up to " + n2 + ": " + Arrays.toString(solver.countBits(n2)));

        int n3 = 10;
        System.out.println("Count bits up to " + n3 + ": " + Arrays.toString(solver.countBits(n3)));
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = getNoOfSetBits(i);
        }

        return result;
    }

    int getNoOfSetBits(int num) {
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            if ((num & (1 << i)) > 0) {
                count++;
            }
        }
        return count;
    }
}
