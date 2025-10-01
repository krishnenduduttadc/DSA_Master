package CP_maths;

/*
===================================================================
    Probability & Expected Value in Competitive Programming
===================================================================

1. PROBABILITY BASICS
   - Probability = (favorable outcomes) / (total outcomes).
   - In CP, often requires modular arithmetic (mod 1e9+7).
   - Example: Probability of rolling sum=7 on 2 dice.

2. EXPECTED VALUE (E[X])
   - Definition: E[X] = Σ (x * P(x))
   - Intuition: Long-run average of random variable X.

   Example: Expected value of rolling 1 fair die:
       E[X] = (1+2+3+4+5+6)/6 = 3.5

3. LINEARITY OF EXPECTATION
   - E[X + Y] = E[X] + E[Y], EVEN if X and Y are dependent!
   - Very powerful in CP (expected steps, expected cost, etc.).

   Example: Expected number of heads in 10 coin tosses:
       E[#Heads] = 10 * (1/2) = 5

4. EXPECTED STEPS EXAMPLE
   - Problem: Start at 0, every step add +1 with prob=0.5, +2 with prob=0.5.
   - Expected value after n steps = n * E[step].
   - E[step] = (1*0.5 + 2*0.5) = 1.5
   - After n steps → Expected position = 1.5 * n

===================================================================
*/

class ProbabilityExpectedValue {

    // Example 1: Expected value of a die roll
    static double expectedValueDie() {
        double sum = 0;
        for (int i = 1; i <= 6; i++) {
            double p = 1.0 / 6.0;
            sum += i * p;
        }
        return sum;
    }

    // Example 2: Probability of sum=7 with 2 dice
    static double probabilitySum7() {
        int favorable = 0, total = 6 * 6;
        for (int d1 = 1; d1 <= 6; d1++) {
            for (int d2 = 1; d2 <= 6; d2++) {
                if (d1 + d2 == 7) favorable++;
            }
        }
        return (double) favorable / total;
    }

    // Example 3: Expected #Heads in N coin tosses
    static double expectedHeads(int N) {
        return N * 0.5; // linearity of expectation
    }

    // Example 4: Expected steps to reach position after n steps
    // Step = +1 with prob=0.5, +2 with prob=0.5
    static double expectedPosition(int n) {
        double expectedStep = 1 * 0.5 + 2 * 0.5; // 1.5
        return n * expectedStep;
    }

    public static void main(String[] args) {
        // ==========================
        // Example 1
        // ==========================
        System.out.println("Expected value of 1 die roll = " + expectedValueDie());
        // 3.5

        // ==========================
        // Example 2
        // ==========================
        System.out.println("Probability sum=7 with 2 dice = " + probabilitySum7());
        // 6/36 = 0.1666...

        // ==========================
        // Example 3
        // ==========================
        int N = 10;
        System.out.println("Expected #Heads in " + N + " tosses = " + expectedHeads(N));
        // 5.0

        // ==========================
        // Example 4
        // ==========================
        int steps = 5;
        System.out.println("Expected position after " + steps + " steps = " + expectedPosition(steps));
        // 5 * 1.5 = 7.5
    }
}
