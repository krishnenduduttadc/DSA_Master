package CP_maths;

import java.util.Arrays;

/*
=============================================================
   FFT & NTT for Polynomial Multiplication
=============================================================

- FFT: works with complex numbers (double precision).
- NTT: works modulo prime (exact, no floating error).
- Application: multiply two polynomials A and B.

Theory:
    C(x) = A(x) * B(x)
    coeff(C,k) = Σ A[i] * B[k-i]
    This is convolution.

NTT Requirements:
    - Modulus p = k*2^m + 1
    - Primitive root g
    - Example: p = 998244353, g = 3
=============================================================
*/

public class FFT_NTT {

    static final int MOD = 998244353;   // good modulus
    static final int G = 3;             // primitive root

    // -------------------------
    // Modular operations
    // -------------------------
    static long modAdd(long a, long b) {
        long res = a + b;
        return res >= MOD ? res - MOD : res;
    }

    static long modSub(long a, long b) {
        long res = a - b;
        return res < 0 ? res + MOD : res;
    }

    static long modMul(long a, long b) {
        return (a * b) % MOD;
    }

    static long modPow(long a, long e) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = modMul(res, a);
            a = modMul(a, a);
            e >>= 1;
        }
        return res;
    }

    static long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    // -------------------------
    // Iterative NTT
    // -------------------------
    static void ntt(long[] a, boolean invert) {
        int n = a.length;

        // bit-reverse permutation
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; j >= bit; bit >>= 1) j -= bit;
            j += bit;
            if (i < j) {
                long tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            long wlen = modPow(G, (MOD - 1) / len);
            if (invert) wlen = modInverse(wlen);
            for (int i = 0; i < n; i += len) {
                long w = 1;
                for (int j = 0; j < len / 2; j++) {
                    long u = a[i + j];
                    long v = modMul(a[i + j + len / 2], w);
                    a[i + j] = modAdd(u, v);
                    a[i + j + len / 2] = modSub(u, v);
                    w = modMul(w, wlen);
                }
            }
        }
        if (invert) {
            long nInv = modInverse(n);
            for (int i = 0; i < n; i++) a[i] = modMul(a[i], nInv);
        }
    }

    // Multiply two polynomials
    static long[] multiply(long[] a, long[] b) {
        int n = 1;
        while (n < a.length + b.length) n <<= 1;
        long[] fa = Arrays.copyOf(a, n);
        long[] fb = Arrays.copyOf(b, n);

        ntt(fa, false);
        ntt(fb, false);
        for (int i = 0; i < n; i++) fa[i] = modMul(fa[i], fb[i]);
        ntt(fa, true);
        return fa;
    }

    // -------------------------
    // Example usage
    // -------------------------
    public static void main(String[] args) {
        // A(x) = 1 + 2x + 3x^2
        long[] A = {1, 2, 3};
        // B(x) = 4 + 5x + 6x^2
        long[] B = {4, 5, 6};

        long[] C = multiply(A, B);

        System.out.println("Product polynomial coefficients:");
        for (int i = 0; i < 6; i++) { // result degree ≤ 4
            System.out.print(C[i] + " ");
        }
        System.out.println();
        // Expected result: [4, 13, 28, 27, 18]
        // Because (1+2x+3x^2)(4+5x+6x^2) = 4 +13x +28x^2 +27x^3 +18x^4
    }
}
