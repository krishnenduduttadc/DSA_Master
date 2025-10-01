package CP_maths;

import java.util.Arrays;

/*
===================================================================
    LINEAR ALGEBRA IN COMPETITIVE PROGRAMMING
===================================================================

1. Systems of Linear Equations
   - Solve: A * x = b
   - Gaussian Elimination (mod p or in doubles).
   - Time complexity: O(n^3)

2. Determinant (det(A))
   - Used to check if matrix is invertible.
   - For square matrix: det(A) ≠ 0 → unique solution.

3. Rank
   - Maximum number of linearly independent rows (or cols).
   - Determines solvability of system.
   - If rank(A) = rank([A|b]) → solution exists.
   - If rank(A) < rank([A|b]) → no solution.

4. Applications in CP
   - Solve linear recurrences (matrix exponentiation).
   - Probability transitions in Markov Chains.
   - Graph problems (Kirchhoff's theorem → count spanning trees).
   - Geometry: line intersection, plane equations.

===================================================================
*/

class LinearAlgebraCP {

    // Gaussian elimination (works with doubles)
    // Returns array x (solution) or null if no solution/infinitely many
    static double[] gaussianElimination(double[][] A, double[] b) {
        int n = A.length;
        int m = A[0].length; // number of variables

        // Augmented matrix
        double[][] mat = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) mat[i][j] = A[i][j];
            mat[i][m] = b[i];
        }

        for (int col = 0, row = 0; col < m && row < n; col++) {
            // Pivot: find row with max abs value in col
            int sel = row;
            for (int i = row; i < n; i++) {
                if (Math.abs(mat[i][col]) > Math.abs(mat[sel][col])) sel = i;
            }
            if (Math.abs(mat[sel][col]) < 1e-9) continue;

            // Swap rows
            double[] tmp = mat[sel];
            mat[sel] = mat[row];
            mat[row] = tmp;

            // Normalize pivot row
            double div = mat[row][col];
            for (int j = col; j <= m; j++) mat[row][j] /= div;

            // Eliminate below & above
            for (int i = 0; i < n; i++) {
                if (i != row) {
                    double factor = mat[i][col];
                    for (int j = col; j <= m; j++) mat[i][j] -= factor * mat[row][j];
                }
            }
            row++;
        }

        // Extract solution
        double[] x = new double[m];
        for (int i = 0; i < m; i++) {
            // Find row with pivot in column i
            int pivotRow = -1;
            for (int j = 0; j < n; j++) {
                if (Math.abs(mat[j][i] - 1) < 1e-9) {
                    pivotRow = j;
                    break;
                }
            }
            if (pivotRow == -1) return null; // No unique solution
            x[i] = mat[pivotRow][m];
        }
        return x;
    }

    // Compute determinant via Gaussian elimination
    static double determinant(double[][] A) {
        int n = A.length;
        double[][] mat = new double[n][n];
        for (int i = 0; i < n; i++) mat[i] = Arrays.copyOf(A[i], n);

        double det = 1;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) pivot = j;
            }
            if (Math.abs(mat[pivot][i]) < 1e-9) return 0;

            if (pivot != i) {
                double[] tmp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = tmp;
                det *= -1;
            }

            det *= mat[i][i];
            double div = mat[i][i];
            for (int j = i; j < n; j++) mat[i][j] /= div;

            for (int j = i + 1; j < n; j++) {
                double factor = mat[j][i];
                for (int k = i; k < n; k++) mat[j][k] -= factor * mat[i][k];
            }
        }
        return det;
    }

    public static void main(String[] args) {
        // Example 1: Solve linear equations
        // 2x + y = 5
        // 4x - 6y = -2
        double[][] A = {
                {2, 1},
                {4, -6}
        };
        double[] b = {5, -2};

        double[] sol = gaussianElimination(A, b);
        System.out.println("Solution: x=" + sol[0] + ", y=" + sol[1]);
        // Expected: x=1, y=3

        // Example 2: Determinant
        double[][] B = {
                {1, 2, 3},
                {0, 1, 4},
                {5, 6, 0}
        };
        System.out.println("Determinant = " + determinant(B));
        // Expected: 1*(1*0-4*6) - 2*(0*0-4*5) + 3*(0*6-1*5) = 1*(-24) -2*(-20) + 3*(-5) = -24+40-15=1
    }
}
