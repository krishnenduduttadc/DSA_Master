package RecursionAndBacktrackingL2;

public class FriendsPairing {
    static int count = 1;

    static void solve(int i, int n, boolean[] used, String ans) {

        // Base case
        if (i > n) {
            System.out.println(count++ + ". " + ans);
            return;
        }

        // If already paired, skip
        if (used[i]) {
            solve(i + 1, n, used, ans);
            return;
        }

        // Option 1: Stay single
        used[i] = true;
        solve(i + 1, n, used, ans + "(" + i + ") ");

        // Option 2: Pair with someone
        for (int j = i + 1; j <= n; j++) {
            if (!used[j]) {
                used[j] = true;
                solve(i + 1, n, used, ans + "(" + i + "," + j + ") ");
                used[j] = false;  // backtrack
            }
        }

        used[i] = false; // backtrack
    }

    public static void main(String[] args) {

        int n = 3;   // Hardcoded input
        boolean[] used = new boolean[n + 1];

        solve(1, n, used, "");
    }
}
