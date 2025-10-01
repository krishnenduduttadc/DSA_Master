package CP_maths;

class NTT {
    /*
    ===============================================================
        Number Theoretic Transform (NTT) for Polynomial Multiplication
    ===============================================================

    Requirements:
      - Prime modulus p = k*2^m + 1
      - Primitive root g modulo p
      - Famous: MOD = 998244353, g = 3

    Why?
      - FFT suffers floating-point errors
      - NTT is exact under modular arithmetic
    ===============================================================
    */

    static final int MOD = 998244353;
    static final int G = 3; // primitive root

    static int modPow(int a, int e) {
        long res = 1, base = a;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            e >>= 1;
        }
        return (int) res;
    }

    static void ntt(int[] a, boolean invert) {
        int n = a.length;

        // Bit reversal
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; j >= bit; bit >>= 1) j -= bit;
            j += bit;
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            int wlen = modPow(G, (MOD - 1) / len);
            if (invert) wlen = modPow(wlen, MOD - 2); // inverse root

            for (int i = 0; i < n; i += len) {
                int w = 1;
                for (int j = 0; j < len / 2; j++) {
                    int u = a[i + j];
                    int v = (int) ((long) a[i + j + len / 2] * w % MOD);
                    a[i + j] = (u + v < MOD ? u + v : u + v - MOD);
                    a[i + j + len / 2] = (u - v >= 0 ? u - v : u - v + MOD);
                    w = (int) ((long) w * wlen % MOD);
                }
            }
        }

        if (invert) {
            int invN = modPow(n, MOD - 2);
            for (int i = 0; i < n; i++) {
                a[i] = (int) ((long) a[i] * invN % MOD);
            }
        }
    }

    static int[] multiply(int[] a, int[] b) {
        int n = 1;
        while (n < a.length + b.length) n <<= 1;

        int[] fa = new int[n];
        int[] fb = new int[n];
        System.arraycopy(a, 0, fa, 0, a.length);
        System.arraycopy(b, 0, fb, 0, b.length);

        ntt(fa, false);
        ntt(fb, false);
        for (int i = 0; i < n; i++) fa[i] = (int) ((long) fa[i] * fb[i] % MOD);
        ntt(fa, true);

        return fa;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3}; // 1 + 2x + 3x^2
        int[] B = {4, 5, 6}; // 4 + 5x + 6x^2

        int[] C = multiply(A, B);
        System.out.println("Polynomial product coefficients (mod 998244353):");
        for (int i = 0; i < A.length + B.length - 1; i++) {
            System.out.print(C[i] + " ");
        }
        // Expected: [4, 13, 28, 27, 18]
    }
}
