package CP_maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
================================================================================
  Probability + DP (Hard) — Theory + Code (Competitive Programming)
================================================================================

OVERVIEW / KEY IDEAS
- Expectation E[X] is linear: E[aX + bY] = aE[X] + bE[Y]. Use linearity even if
  variables are dependent.
- Many "expected steps" problems produce recurrences of the form:
      E[state] = 1 + sum_{next} P(state -> next) * E[next]
  Solve these recurrences. If graph is acyclic or can be topologically ordered,
  compute with DP. If cycles exist, we generally need to solve a linear system:
      (1 - P[state->state]) * E[state] - sum_{next != state} P(state->next) * E[next] = 1
- Use memoized recursion for DAG-like transitions. Use Gaussian elimination
  (over doubles) to solve linear systems when states are interdependent.
- Special closed-form results:
    * Geometric distribution: expected trials till first success with prob p -> 1/p
    * Negative binomial: expected trials to get k successes with prob p -> k/p
    * Coupon collector: expected draws to collect n distinct coupons -> n * H_n
- Random walk / Gambler's ruin: often produce linear recurrences solvable with
  either closed form or linear system.

This file provides utilities and examples:
  1) simple DP via recursion + memo (unambiguous acyclic)
  2) expected flips until k heads (negative binomial)
  3) gambler's ruin expected time (random walk with absorbing boundaries)
  4) general absorbing Markov chain solved by Gaussian elimination
  5) coupon collector expectation
  6) Gaussian elimination utility for solving Ax = b (double)

Note: Use doubles; be mindful of precision (EPS). For modular probability variations,
use modular arithmetic + modular inverse (not covered here).
================================================================================
*/

public class ProbabilityDP {

    // ---------------------------
    // Utility: Gaussian elimination (double) to solve linear system Ax = b
    // returns null if singular (no unique solution)
    // ---------------------------
    static double[] gaussSolve(double[][] A, double[] b) {
        int n = A.length;
        double EPS = 1e-12;
        // Augmented matrix
        double[][] aug = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, aug[i], 0, n);
            aug[i][n] = b[i];
        }

        int row = 0;
        for (int col = 0; col < n && row < n; col++) {
            // find pivot
            int sel = row;
            for (int i = row; i < n; i++) {
                if (Math.abs(aug[i][col]) > Math.abs(aug[sel][col])) sel = i;
            }
            if (Math.abs(aug[sel][col]) < EPS) continue; // no pivot in this column
            // swap
            double[] tmp = aug[row];
            aug[row] = aug[sel];
            aug[sel] = tmp;

            // normalize row
            double pivot = aug[row][col];
            for (int j = col; j <= n; j++) aug[row][j] /= pivot;

            // eliminate other rows
            for (int i = 0; i < n; i++) {
                if (i != row) {
                    double factor = aug[i][col];
                    if (Math.abs(factor) < EPS) continue;
                    for (int j = col; j <= n; j++) aug[i][j] -= factor * aug[row][j];
                }
            }
            row++;
        }

        // check consistency and extract solution
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            int pivotCol = -1;
            for (int j = 0; j < n; j++) {
                if (Math.abs(aug[i][j]) > 1e-9) {
                    pivotCol = j;
                    break;
                }
            }
            if (pivotCol == -1) {
                if (Math.abs(aug[i][n]) > 1e-9) {
                    // 0 = nonzero -> no solution
                    return null;
                }
                continue; // all zero row
            } else {
                x[pivotCol] = aug[i][n];
            }
        }
        return x;
    }

    // ---------------------------
    // Example 1: Negative-Binomial (expected flips until k heads)
    // Theory:
    //  - Each flip has prob p of head. Expected number of flips to get k heads = k / p.
    //  - Derivation: linearity of expectation using representation as sum of geometric RVs.
    // ---------------------------
    static double expectedFlipsForKHeads(int k, double p) {
        if (p <= 0) return Double.POSITIVE_INFINITY;
        return k / p;
    }

    // ---------------------------
    // Example 2: Coupon Collector
    // Theory:
    //  - To collect all n distinct coupons when each draw picks uniformly at random:
    //    expected draws = n * (1 + 1/2 + 1/3 + ... + 1/n) = n * H_n
    // ---------------------------
    static double couponCollectorExpectation(int n) {
        double h = 0.0;
        for (int i = 1; i <= n; i++) h += 1.0 / i;
        return n * h;
    }

    // ---------------------------
    // Example 3: Gambler's Ruin (expected time to absorption)
    // Random walk on integers 0..N, start at i, 0 and N absorbing.
    // Transition: move +1 with prob p, -1 with prob q=1-p.
    //
    // If p == q == 0.5 (symmetric):
    //   Expected time E[i] = i*(N - i)
    // Else:
    //   E[i] = [i - ( (1 - ( (q/p)^i )) / (1 - (q/p)^N) * N )] / (q - p)
    // But it's often easier/safer to set linear system:
    //   For 1 <= i <= N-1:
    //     E[i] = 1 + p * E[i+1] + q * E[i-1]
    //   E[0] = E[N] = 0
    //
    // We'll build the linear system and solve by Gaussian elimination.
    // ---------------------------
    static double[] gamblerRuinExpectedTime(int N, double p) {
        double q = 1.0 - p;
        int m = N - 1; // unknowns E[1..N-1]
        if (m <= 0) return new double[0];
        double[][] A = new double[m][m];
        double[] b = new double[m];
        for (int i = 1; i <= m; i++) {
            int row = i - 1;
            A[row][row] = 1.0;
            b[row] = 1.0; // constant term

            if (i - 1 >= 1) A[row][row - 1] = -q;
            else {
                // E[0] = 0 => term moves to b as 0 -> no change
            }
            if (i + 1 <= m) A[row][row + 1] = -p;
            else {
                // E[N] = 0
            }
        }
        double[] sol = gaussSolve(A, b);
        // sol corresponds to E[1..N-1]
        double[] E = new double[N + 1];
        E[0] = 0;
        E[N] = 0;
        for (int i = 1; i <= m; i++) E[i] = sol[i - 1];
        return E;
    }

    // ---------------------------
    // Example 4: General absorbing Markov chain expected time to absorption
    // States: 0..S-1, some subset absorbing (when you reach them, process stops).
    // For transient states t:
    //    E[t] = 1 + sum_{u transient} P[t->u] * E[u] + sum_{a absorbing} P[t->a] * 0
    // Rearranged:
    //    (1 - P[t->t]) E[t] - sum_{u != t} P[t->u] * E[u] = 1
    //
    // We build linear system over all transient states and solve.
    // ---------------------------
    static double[] expectedTimeAbsorbing(int S, boolean[] isAbsorbing, List<double[]> transitions) {
        // transitions.get[i] is double[] of length S giving P[i->j] for j=0..S-1
        // Build index map for transient states
        int[] idx = new int[S];
        Arrays.fill(idx, -1);
        int cnt = 0;
        for (int i = 0; i < S; i++) if (!isAbsorbing[i]) idx[i] = cnt++;
        if (cnt == 0) return new double[0];

        double[][] A = new double[cnt][cnt];
        double[] b = new double[cnt];

        for (int i = 0; i < S; i++) {
            if (isAbsorbing[i]) continue;
            int row = idx[i];
            b[row] = 1.0;
            A[row][row] = 1.0 - transitions.get(i)[i]; // 1 - P[i->i]
            for (int j = 0; j < S; j++) {
                if (i == j) continue;
                if (!isAbsorbing[j]) {
                    int col = idx[j];
                    A[row][col] = -transitions.get(i)[j];
                } else {
                    // absorbing j contributes 0 to E (nothing to add), but could be used if want absorption probabilities
                }
            }
        }

        double[] sol = gaussSolve(A, b);
        // Map back to full state vector
        double[] E = new double[S];
        for (int i = 0; i < S; i++) {
            if (isAbsorbing[i]) E[i] = 0.0;
            else E[i] = sol[idx[i]];
        }
        return E;
    }

    // ---------------------------
    // Example 5: DP with probability and expectation on DAG (simple)
    // e.g., expected reward when moving along acyclic edges where edges have probabilities.
    // For DAG you can compute E in topological order:
    //   E[u] = reward[u] + sum_{v} P[u->v] * E[v]
    // ---------------------------
    static double[] expectedOnDAG(int S, double[] reward, List<int[]> edges, List<double[]> probs) {
        // edges.get[i] = array of neighbors from i, probs.get[i] = same length probabilities
        // We'll do a simple DP by topological order; user must provide DAG ordering for correctness
        // For general usage, compute topological order externally or trust that input is DAG and edges are given in topological order
        double[] E = new double[S];
        // process nodes in reverse topological (here we assume edges are topological: u->v where u < v)
        for (int u = S - 1; u >= 0; u--) {
            E[u] = reward[u];
            int[] nei = edges.get(u);
            double[] p = probs.get(u);
            for (int k = 0; k < nei.length; k++) {
                E[u] += p[k] * E[nei[k]];
            }
        }
        return E;
    }

    // ---------------------------
    // Demonstrations in main()
    // ---------------------------
    public static void main(String[] args) {
        System.out.println("=== Probability + DP (Hard) examples ===");

        // --- Negative binomial example ---
        int k = 5;
        double p = 0.3;
        System.out.printf("Expected flips to get %d heads with p=%.3f -> %.6f%n",
                k, p, expectedFlipsForKHeads(k, p));

        // --- Coupon collector ---
        int n = 10;
        System.out.printf("Coupon collector for n=%d -> expectation = %.6f%n", n, couponCollectorExpectation(n));

        // --- Gambler's ruin example ---
        int N = 10; // states 0..10
        double probRight = 0.4; // p
        double[] Egr = gamblerRuinExpectedTime(N, probRight);
        System.out.println("Gambler's ruin expected times E[i] for i=0.." + N);
        for (int i = 0; i <= N; i++) {
            System.out.printf("E[%d] = %.6f%n", i, Egr[i]);
        }

        // Verify symmetric random walk closed form: p=0.5 -> E[i] = i*(N-i)
        double[] E_sym = gamblerRuinExpectedTime(10, 0.5);
        System.out.println("\nSymmetric random walk (p=0.5), compare to closed form i*(N-i):");
        for (int i = 0; i <= 10; i++) {
            System.out.printf("i=%d: linear-solve=%.6f , i*(N-i)=%.6f%n", i, E_sym[i], i * (10 - i) * 1.0);
        }

        // --- Absorbing Markov chain example ---
        // Small chain: 4 states {0,1,2,3}, 0 and 3 absorbing, transitions:
        // 1 -> 0 with 0.2, 1 -> 2 with 0.8
        // 2 -> 3 with 0.5, 2 -> 1 with 0.5
        int S = 4;
        boolean[] absorbing = new boolean[]{true, false, false, true};
        List<double[]> trans = new ArrayList<>();
        // fill transition probability rows
        trans.add(new double[]{1.0, 0.0, 0.0, 0.0}); // state 0 absorbing
        trans.add(new double[]{0.2, 0.0, 0.8, 0.0}); // state 1
        trans.add(new double[]{0.0, 0.5, 0.0, 0.5}); // state 2
        trans.add(new double[]{0.0, 0.0, 0.0, 1.0}); // state 3 absorbing
        double[] Eabs = expectedTimeAbsorbing(S, absorbing, trans);
        System.out.println("\nExpected time to absorption from each state:");
        for (int i = 0; i < S; i++) System.out.printf("E[%d]=%.6f%n", i, Eabs[i]);
        // Interpretation: E[1] is expected steps to reach 0 or 3 from 1, etc.

        // --- DAG expectation example ---
        // Simple DAG: 0 -> 1 (p=0.4), 0 -> 2 (p=0.6), 1 -> 3 (p=1), 2 -> 3 (p=1), 3 terminal reward 10
        int Sdag = 4;
        double[] reward = new double[]{0, 0, 0, 10};
        List<int[]> edges = new ArrayList<>();
        List<double[]> probs = new ArrayList<>();
        edges.add(new int[]{1, 2});
        probs.add(new double[]{0.4, 0.6});
        edges.add(new int[]{3});
        probs.add(new double[]{1.0});
        edges.add(new int[]{3});
        probs.add(new double[]{1.0});
        edges.add(new int[]{});
        probs.add(new double[]{});
        double[] Edag = expectedOnDAG(Sdag, reward, edges, probs);
        System.out.println("\nExpectation on DAG (expected reward starting at node 0): " + Edag[0]);
    }
}
