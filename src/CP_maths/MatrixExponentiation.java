package CP_maths;

/*
===============================================================
    MATRIX EXPONENTIATION
    ===============================================================

    ⚡ Why important in CP?
    - Many DP and recurrence problems are of form:
        F(n) = c1*F(n-1) + c2*F(n-2) + ... + ck*F(n-k)
      Example:
        Fibonacci: F(n) = F(n-1) + F(n-2)
        Tribonacci: F(n) = F(n-1) + F(n-2) + F(n-3)
        Linear recurrences in DP

    - Naive recurrence is O(n), but matrix exponentiation reduces it to O(k^3 log n)

    ---------------------------------------------------------------
    1. Fibonacci with Matrix Exponentiation
       F(n) recurrence:
         F(n) = F(n-1) + F(n-2)

       Matrix form:
         [ F(n)   ]   [1 1] [F(n-1)]
         [ F(n-1) ] = [1 0] [F(n-2)]

       So:
         [F(n) F(n-1)]^T = (TransitionMatrix)^(n-1) * [F(1) F(0)]^T

    ---------------------------------------------------------------
    2. General Recurrence
       Suppose:
         F(n) = c1*F(n-1) + c2*F(n-2) + ... + ck*F(n-k)

       Matrix form (k x k):
         [F(n)  ]   [c1 c2 ... ck] [F(n-1)]
         [F(n-1)] = [1  0  ...  0] [F(n-2)]
         [F(n-2)]   [0  1  ...  0] [F(n-3)]
         [...   ]   [...         ] [...   ]
         [F(n-k+1)] [0  0  ...  1] [F(n-k)]

       Then compute TransitionMatrix^(n-k+1)

    ---------------------------------------------------------------
    3. Complexity:
       Matrix multiply = O(k^3)
       Exponentiation = O(log n)
       Total = O(k^3 log n)

===============================================================
*/

class MatrixExponentiation {
    static final long MOD = 1000000007;

    // Multiply two matrices under mod
    static long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        int m = B[0].length;
        int p = B.length;
        long[][] C = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    // Fast exponentiation of matrix
    static long[][] power(long[][] A, long exp) {
        int n = A.length;
        long[][] res = new long[n][n];
        // Identity matrix
        for (int i = 0; i < n; i++) res[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) res = multiply(res, A);
            A = multiply(A, A);
            exp >>= 1;
        }
        return res;
    }

    // Fibonacci using Matrix Exponentiation
    static long fibonacci(long n) {
        if (n == 0) return 0;
        long[][] F = {{1, 1}, {1, 0}};
        long[][] Fn = power(F, n - 1);
        return Fn[0][0]; // F(n)
    }

    // General recurrence solver
    // recurrence: F(n) = c1*F(n-1) + c2*F(n-2) + ... + ck*F(n-k)
    static long solveRecurrence(long[] coeff, long[] init, long n) {
        int k = coeff.length;
        if (n < init.length) return init[(int) n];

        // Build transition matrix
        long[][] T = new long[k][k];
        for (int j = 0; j < k; j++) {
            T[0][j] = coeff[j] % MOD; // first row = coefficients
        }
        for (int i = 1; i < k; i++) {
            T[i][i - 1] = 1; // shift
        }

        // Raise matrix to power (n-k+1)
        long[][] Tn = power(T, n - k + 1);

        // Multiply with initial vector
        long res = 0;
        for (int j = 0; j < k; j++) {
            res = (res + Tn[0][j] * init[k - 1 - j]) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        // ===== Fibonacci =====
        System.out.println("Fibonacci(10) = " + fibonacci(10)); // Expected 55
        System.out.println("Fibonacci(50) = " + fibonacci(50)); // Expected 12586269025 % MOD

        // ===== General Recurrence =====
        // Tribonacci: F(n) = F(n-1) + F(n-2) + F(n-3)
        long[] coeff = {1, 1, 1};  // recurrence coefficients
        long[] init = {0, 1, 1};   // F(0)=0, F(1)=1, F(2)=1
        System.out.println("Tribonacci(10) = " + solveRecurrence(coeff, init, 10));

        // Example DP: F(n) = 2*F(n-1) + 3*F(n-2)
        long[] coeff2 = {2, 3};
        long[] init2 = {1, 2}; // F(0)=1, F(1)=2
        System.out.println("F(10) for custom recurrence = " + solveRecurrence(coeff2, init2, 10));
    }
}

/*
===============================================================
⚡ Key Takeaways:
- Matrix exponentiation lets you compute k-term linear recurrences in O(k^3 log n)
- Fibonacci, Tribonacci, and many DP recurrences can be optimized this way
- Transition matrix is the core idea
===============================================================
*/

