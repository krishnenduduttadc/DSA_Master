package LeetCodePatterns.GameTheory;

public class Nim {
    public static void main(String[] args) {
        Nim game = new Nim();

        int[] testCases = {1, 4, 7, 10, 15, 16, 21};

        for (int n : testCases) {
            System.out.println("Stones: " + n + " -> Can first player win? " + game.canWinNim(n));
        }
    }

    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }

}
