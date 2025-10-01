package CP_maths;

import java.util.Arrays;

/*
========================================================================
  FWHT (Fast Walsh–Hadamard Transform) for XOR / OR / AND convolutions
========================================================================

Theory (short):
- FWHT is an analogue of FFT for "bitwise" convolutions over indices (masks).
- For functions f, g defined on masks [0..2^k-1], we can define three
  useful convolutions:

  XOR-convolution:
    h[z] = sum_{x ^ y = z} f[x] * g[y]

  OR-convolution:
    h[z] = sum_{x | y = z} f[x] * g[y]

  AND-convolution:
    h[z] = sum_{x & y = z} f[x] * g[y]

- Each of these can be computed by:
    1) applying the appropriate FWHT to f and g,
    2) pointwise multiply transformed arrays,
    3) inverse FWHT.

Transforms (in-place) for length n = 2^k:

  XOR FWHT:
    for len=1..n:
      for blocks of size 2*len:
        for i in 0..len-1:
          u = a[base + i]; v = a[base + i + len];
          a[base+i]        = u + v;
          a[base+i+len]    = u - v;
    - inverse is same transform followed by dividing every element by n (or multiply by inv(n) mod MOD).

  OR FWHT (forward):
    for len=1..n:
      for blocks:
        for i in 0..len-1:
          u = a[base + i]; v = a[base + i + len];
          a[base + i]      = u + v;    // sums contributions where bit is 0
          a[base + i + len]= v;        // contributions where bit is 1
    inverse OR:
          a[base + i]      = u - v;
          a[base + i + len]= v;

  AND FWHT (forward):
    for len=1..n:
      for blocks:
        for i in 0..len-1:
          u = a[base + i]; v = a[base + i + len];
          a[base + i]      = u;        // bit 0 stays
          a[base + i + len]= u + v;    // sums contributions where bit is 1
    inverse AND:
          a[base + i]      = u;
          a[base + i + len]= v - u;

- Use modular arithmetic for all operations in contests (we use MOD).
- XOR convolution requires dividing by n in the inverse; compute inv(n) via modPow.

Complexity: O(n log n) and memory O(n).

========================================================================
*/

public class FWHT {

    static final long MOD = 1_000_000_007L; // change if needed (prime recommended)

    // modular helpers
    static long add(long a, long b) {
        a += b;
        if (a >= MOD) a -= MOD;
        return a;
    }

    static long sub(long a, long b) {
        a -= b;
        if (a < 0) a += MOD;
        return a;
    }

    static long mul(long a, long b) {
        return (a * b) % MOD;
    }

    static long modPow(long a, long e) {
        long r = 1 % MOD;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = mul(r, a);
            a = mul(a, a);
            e >>= 1;
        }
        return r;
    }

    // -------------------------
    // XOR FWHT (in-place). If invert==true, performs inverse transform.
    // After inverse, you must multiply all elements by invN = (1/n) mod MOD.
    // -------------------------
    static void fwhtXor(long[] a, boolean invert) {
        int n = a.length;
        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += (len << 1)) {
                for (int j = 0; j < len; j++) {
                    long u = a[i + j];
                    long v = a[i + j + len];
                    a[i + j] = add(u, v);
                    a[i + j + len] = sub(u, v);
                }
            }
        }
        if (invert) {
            long invN = modPow(n, MOD - 2);
            for (int i = 0; i < n; i++) a[i] = mul(a[i], invN);
        }
    }

    // -------------------------
    // OR FWHT (in-place). If invert==true, performs inverse OR transform.
    // -------------------------
    static void fwhtOr(long[] a, boolean invert) {
        int n = a.length;
        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += (len << 1)) {
                for (int j = 0; j < len; j++) {
                    long u = a[i + j];
                    long v = a[i + j + len];
                    if (!invert) {
                        // forward OR
                        a[i + j] = add(u, v);
                        a[i + j + len] = v;
                    } else {
                        // inverse OR
                        a[i + j] = sub(u, v);
                        a[i + j + len] = v;
                    }
                }
            }
        }
    }

    // -------------------------
    // AND FWHT (in-place). If invert==true, performs inverse AND transform.
    // -------------------------
    static void fwhtAnd(long[] a, boolean invert) {
        int n = a.length;
        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += (len << 1)) {
                for (int j = 0; j < len; j++) {
                    long u = a[i + j];
                    long v = a[i + j + len];
                    if (!invert) {
                        // forward AND
                        a[i + j] = u;
                        a[i + j + len] = add(u, v);
                    } else {
                        // inverse AND
                        a[i + j] = u;
                        a[i + j + len] = sub(v, u);
                    }
                }
            }
        }
    }

    // -------------------------
    // Convolution wrappers
    // Given f and g of size n=2^k, returns convolution h under XOR/OR/AND.
    // -------------------------
    static long[] convolutionXor(long[] f, long[] g) {
        int n = 1;
        while (n < f.length || n < g.length) n <<= 1;
        n <<= 0; // n is power of two >= sizes
        long[] A = Arrays.copyOf(f, n);
        long[] B = Arrays.copyOf(g, n);
        fwhtXor(A, false);
        fwhtXor(B, false);
        for (int i = 0; i < n; i++) A[i] = mul(A[i], B[i]);
        fwhtXor(A, true); // inverse (includes dividing by n)
        return A;
    }

    static long[] convolutionOr(long[] f, long[] g) {
        int n = 1;
        while (n < f.length || n < g.length) n <<= 1;
        long[] A = Arrays.copyOf(f, n);
        long[] B = Arrays.copyOf(g, n);
        fwhtOr(A, false);
        fwhtOr(B, false);
        for (int i = 0; i < n; i++) A[i] = mul(A[i], B[i]);
        fwhtOr(A, true);
        return A;
    }

    static long[] convolutionAnd(long[] f, long[] g) {
        int n = 1;
        while (n < f.length || n < g.length) n <<= 1;
        long[] A = Arrays.copyOf(f, n);
        long[] B = Arrays.copyOf(g, n);
        fwhtAnd(A, false);
        fwhtAnd(B, false);
        for (int i = 0; i < n; i++) A[i] = mul(A[i], B[i]);
        fwhtAnd(A, true);
        return A;
    }

    // -------------------------
    // Quick examples (run main)
    // -------------------------
    public static void main(String[] args) {
        // Example for XOR convolution:
        // f = indicator of {0,1} ; g = indicator of {0,2}
        // f[0]=1, f[1]=1, rest 0
        // g[0]=1, g[2]=1, rest 0
        // h[z] = sum_{x^y=z} f[x]*g[y]
        int K = 3; // bit-length (masks 0..7)
        int n = 1 << K;
        long[] f = new long[n];
        long[] g = new long[n];
        f[0] = 1;
        f[1] = 1;
        g[0] = 1;
        g[2] = 1;

        long[] hx = convolutionXor(f, g);
        System.out.println("XOR-convolution result (h[z] = sum_{x^y=z} f[x]*g[y]):");
        for (int i = 0; i < n; i++) System.out.print(hx[i] + " ");
        System.out.println();
        // Let's verify manually: possible pairs (x,y) with f[x]=1,g[y]=1:
        // (0,0)->0, (0,2)->2, (1,0)->1, (1,2)->3
        // so h[0]=1,h[1]=1,h[2]=1,h[3]=1, rest 0

        // Example for OR convolution:
        // f = indicator {1}, g = indicator {2}
        // Masks 0..3 (K=2)
        K = 2;
        n = 1 << K;
        f = new long[n];
        g = new long[n];
        f[1] = 1; // mask 01
        g[2] = 1; // mask 10
        long[] hor = convolutionOr(f, g);
        System.out.println("OR-convolution (h[z] = sum_{x|y=z} f[x]*g[y]):");
        for (int i = 0; i < n; i++) System.out.print(hor[i] + " ");
        System.out.println();
        // Only pair (1|2)=3 so h[3]=1

        // Example for AND convolution:
        // f indicator {3}, g indicator {1}
        K = 2;
        n = 1 << K;
        f = new long[n];
        g = new long[n];
        f[3] = 1; // 11
        g[1] = 1; // 01
        long[] hand = convolutionAnd(f, g);
        System.out.println("AND-convolution (h[z] = sum_{x&y=z} f[x]*g[y]):");
        for (int i = 0; i < n; i++) System.out.print(hand[i] + " ");
        System.out.println();
        // (3 & 1) = 1 => h[1]=1

        // Example: XOR convolution for polynomial multiplication trick:
        // If you have frequency arrays of subset sizes, FWHT/XOR may be used in more advanced transforms.
    }
}
