package CP_maths;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
===================================================================
    Game Theory Basics for CP
===================================================================

1. Impartial Games:
   - Both players have the same set of moves.
   - Examples: Nim, removing stones, coin games.

2. Nim Game (Classic):
   - We have multiple piles of stones.
   - A move = pick any pile and remove ≥1 stones.
   - Player unable to move (all piles empty) loses.

   RULE:
   - If XOR of all pile sizes == 0 → Losing position
   - Else → Winning position

3. Sprague-Grundy Theorem:
   - Any impartial game is equivalent to a Nim pile of some size (Grundy number).
   - Grundy state of a position = mex({Grundy of next states})
   - mex(S) = minimum excluded non-negative integer.

   RULE:
   - Compute Grundy number for each pile/state.
   - XOR all Grundy numbers:
       0 → Losing state
       non-zero → Winning state
===================================================================
*/

class GameTheory {

    // Classic Nim Game: check if first player wins
    static boolean nimGame(int[] piles) {
        int xorSum = 0;
        for (int p : piles) xorSum ^= p;
        return xorSum != 0; // true → winning position
    }

    // mex (minimum excluded) for Grundy computation
    static int mex(Set<Integer> set) {
        int m = 0;
        while (set.contains(m)) m++;
        return m;
    }

    // Example Grundy function for "subtract-a-square" game:
    // From n, you can move to n - k^2 (where k^2 ≤ n)
    static int grundySquareGame(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        Set<Integer> nextStates = new HashSet<>();
        for (int k = 1; k * k <= n; k++) {
            nextStates.add(grundySquareGame(n - k * k, dp));
        }

        return dp[n] = mex(nextStates);
    }

    public static void main(String[] args) {
        // ==========================
        // Example 1: Classic Nim
        // ==========================
        int[] piles = {3, 4, 5};
        System.out.println("Nim Game Result: " + (nimGame(piles) ? "First Player Wins" : "Second Player Wins"));
        // XOR = 3 ^ 4 ^ 5 = 2 ≠ 0 → First player wins

        // ==========================
        // Example 2: Subtract-a-Square Game
        // ==========================
        int N = 15; // starting number
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);

        int g = grundySquareGame(N, dp);
        System.out.println("Grundy Number of N=" + N + " is " + g);
        System.out.println((g != 0) ? "First Player Wins" : "Second Player Wins");
    }
}
