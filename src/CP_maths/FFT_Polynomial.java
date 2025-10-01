package CP_maths;

class FFT_Polynomial {
    /*
    ===============================================================
        Fast Fourier Transform (FFT) for Polynomial Multiplication
    ===============================================================

    Polynomial multiplication:
      (a0 + a1*x + ... + an*x^n) * (b0 + b1*x + ... + bm*x^m)
      => coefficients by convolution.

    Naive: O(n^2), too slow for n=1e5
    FFT:   O(n log n), practical for CP.

    Steps:
      1. Pad arrays to nearest power of 2.
      2. Apply FFT to both arrays.
      3. Multiply pointwise in frequency domain.
      4. Apply Inverse FFT to get coefficients back.
    ===============================================================
    */

    static void fft(Complex[] a, boolean invert) {
        int n = a.length;

        // Bit reversal permutation
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; j >= bit; bit >>= 1) j -= bit;
            j += bit;
            if (i < j) {
                Complex tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            Complex wlen = new Complex(Math.cos(ang), Math.sin(ang));
            for (int i = 0; i < n; i += len) {
                Complex w = new Complex(1, 0);
                for (int j = 0; j < len / 2; j++) {
                    Complex u = a[i + j];
                    Complex v = a[i + j + len / 2].mul(w);
                    a[i + j] = u.add(v);
                    a[i + j + len / 2] = u.sub(v);
                    w = w.mul(wlen);
                }
            }
        }

        if (invert) {
            for (int i = 0; i < n; i++) {
                a[i].re /= n;
                a[i].im /= n;
            }
        }
    }

    // Multiply two polynomials
    static long[] multiply(long[] a, long[] b) {
        int n = 1;
        while (n < a.length + b.length) n <<= 1;

        Complex[] fa = new Complex[n];
        Complex[] fb = new Complex[n];
        for (int i = 0; i < n; i++) {
            fa[i] = new Complex(i < a.length ? a[i] : 0, 0);
            fb[i] = new Complex(i < b.length ? b[i] : 0, 0);
        }

        fft(fa, false);
        fft(fb, false);
        for (int i = 0; i < n; i++) fa[i] = fa[i].mul(fb[i]);
        fft(fa, true);

        long[] res = new long[n];
        for (int i = 0; i < n; i++) res[i] = Math.round(fa[i].re);
        return res;
    }

    public static void main(String[] args) {
        long[] A = {1, 2, 3};   // 1 + 2x + 3x^2
        long[] B = {4, 5, 6};   // 4 + 5x + 6x^2

        long[] C = multiply(A, B);
        System.out.println("Polynomial product coefficients:");
        for (int i = 0; i < A.length + B.length - 1; i++) {
            System.out.print(C[i] + " ");
        }
        // Expected: [4, 13, 28, 27, 18]
        // (1+2x+3x^2)*(4+5x+6x^2)
    }

    static class Complex {
        double re, im;

        Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        Complex add(Complex o) {
            return new Complex(re + o.re, im + o.im);
        }

        Complex sub(Complex o) {
            return new Complex(re - o.re, im - o.im);
        }

        Complex mul(Complex o) {
            return new Complex(re * o.re - im * o.im, re * o.im + im * o.re);
        }
    }
}

