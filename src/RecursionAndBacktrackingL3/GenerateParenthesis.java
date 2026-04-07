package RecursionAndBacktrackingL3;

public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        backtrack(n, 0, 0, "");
    }

    public static void backtrack(int n, int open, int close, String current) {

        if (current.length() == 2 * n) {
            System.out.println(current);
            return;
        }

        // Add "("
        if (open < n) {
            backtrack(n, open + 1, close, current + "(");
        }

        // Add ")"
        if (close < open) {
            backtrack(n, open, close + 1, current + ")");
        }
    }

}
