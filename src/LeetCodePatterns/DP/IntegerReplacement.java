package LeetCodePatterns.DP;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    private Map<Integer, Integer> ht;

    // Main method to test the program
    public static void main(String[] args) {
        IntegerReplacement solver = new IntegerReplacement();

        int n = 8; // Example input
        int steps = solver.integerReplacement(n);

        System.out.println("Minimum steps to reduce " + n + " to 1: " + steps);

        // Try another input
        int n2 = 7;
        int steps2 = solver.integerReplacement(n2);
        System.out.println("Minimum steps to reduce " + n2 + " to 1: " + steps2);
    }

    public int integerReplacement(int n) {
        ht = new HashMap<>();
        ht.put(1, 0);
        ht.put(2147483647, 32); // safeguard for overflow edge case
        return f(n);
    }

    private int f(int x) {
        if (ht.containsKey(x)) {
            return ht.get(x);
        }
        int ans;
        if (x % 2 == 0) {
            ans = f(x / 2) + 1;
        } else {
            ans = Math.min(f(x - 1), f(x + 1)) + 1;
        }
        ht.put(x, ans);
        return ans;
    }
}
