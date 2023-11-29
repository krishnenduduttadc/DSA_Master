package Concepts;

import java.util.Arrays;

public class NumberTheoryExamples {

    public static void main(String[] args) {
        // 1. Divisibility
        int number = 15;
        int divisor = 3;
        boolean isDivisible = (number % divisor == 0);
        System.out.println("Is 15 divisible by 3? " + isDivisible);

        // 2. Prime Numbers
        int num = 7;
        boolean isPrime = isPrime(num);
        System.out.println(num + " is a prime number? " + isPrime);

        // 3. Greatest Common Divisor (GCD)
        int a = 48;
        int b = 18;
        int gcd = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " is " + gcd);

        // 4. Least Common Multiple (LCM)
        int x = 12;
        int y = 18;
        int lcm = lcm(x, y);
        System.out.println("LCM of " + x + " and " + y + " is " + lcm);

        // 5. Modular Arithmetic
        int modResult = mod(7, 3);
        System.out.println("7 mod 3 is " + modResult);

        // 6. Congruences
        int aCong = 17;
        int bCong = 5;
        int mCong = 6;
        boolean congruent = isCongruent(aCong, bCong, mCong);
        System.out.println(aCong + " is congruent to " + bCong + " mod " + mCong + "? " + congruent);

        // 7. Fermat's Little Theorem
        int pFermat = 7;
        int aFermat = 2;
        int resultFermat = modPow(aFermat, pFermat - 1, pFermat);
        System.out.println(aFermat + "^" + (pFermat - 1) + " mod " + pFermat + " is " + resultFermat);

        // 8. Chinese Remainder Theorem
        int[] modsCRT = {3, 5, 7};
        int[] remaindersCRT = {2, 3, 2};
        int resultCRT = chineseRemainderTheorem(modsCRT, remaindersCRT);
        System.out.println("The solution is x ≡ " + resultCRT + " mod " + Arrays.stream(modsCRT).reduce(1, (aCRT, bCRT) -> aCRT * bCRT));

        // 9. Quadratic Residues
        int modulusResidues = 5;
        for (int aResidue = 0; aResidue < modulusResidues; aResidue++) {
            int squareResidue = (aResidue * aResidue) % modulusResidues;
            System.out.println(aResidue + " is a quadratic residue: " + (squareResidue == aResidue));
        }

        // 10. Diophantine Equations
        int aDioph = 3;
        int bDioph = 5;
        int cDioph = 12;
        int[] solutionDioph = solveDiophantineEquation(aDioph, bDioph, cDioph);
        System.out.println("Solution to " + aDioph + "x + " + bDioph + "y = " + cDioph + ": x = " + solutionDioph[0] + ", y = " + solutionDioph[1]);

        // 11. Euler's Totient Function
        int nTotient = 12;
        int phiTotient = eulerTotientFunction(nTotient);
        System.out.println("Euler's totient function of " + nTotient + " is " + phiTotient);
    }

    // Prime Numbers
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Greatest Common Divisor (GCD)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Least Common Multiple (LCM)
    private static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    // Modular Arithmetic
    private static int mod(int a, int m) {
        return a % m;
    }

    // Congruences
    private static boolean isCongruent(int a, int b, int m) {
        return a % m == b % m;
    }

    // Modular exponentiation
    private static int modPow(int base, int exponent, int modulus) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent /= 2;
        }
        return result;
    }

    // Chinese Remainder Theorem
    private static int chineseRemainderTheorem(int[] mods, int[] remainders) {
        int product = Arrays.stream(mods).reduce(1, (a, b) -> a * b);
        int result = 0;
        for (int i = 0; i < mods.length; i++) {
            int ni = product / mods[i];
            result += remainders[i] * modInverse(ni, mods[i]) * ni;
        }
        return result % product;
    }

    // Modular inverse
    private static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; // Not found
    }

    // Diophantine equation solver
    private static int[] solveDiophantineEquation(int a, int b, int c) {
        int[] result = new int[2];
        int gcd = gcd(a, b);
        if (c % gcd == 0) {
            int factor = c / gcd;
            result[0] = factor * (a / gcd);
            result[1] = factor * (b / gcd);
        }
        return result;
    }

    // Euler's totient function
    private static int eulerTotientFunction(int n) {
        int result = n; // Initialize result as n
        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}

