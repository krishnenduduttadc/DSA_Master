package CP_maths;

/*
===============================================================
    GCD (Greatest Common Divisor) and LCM (Least Common Multiple)
    ===============================================================
    ⚡ Why is this important in CP?
    - Used in number theory, modular arithmetic, fractions, ratios, combinatorics
    - Many Codeforces/CodeChef problems involve GCD-based math

    ---------------------------------------------------------------
    1. GCD Definition:
       gcd(a, b) = largest integer d that divides both a and b.
       Example: gcd(24, 18) = 6

    ---------------------------------------------------------------
    2. Euclidean Algorithm (Fastest way to compute gcd)
       gcd(a, b) = gcd(b, a % b)
       Base case: gcd(a, 0) = a
       Complexity: O(log(min(a,b)))

    ---------------------------------------------------------------
    3. Extended Euclidean Algorithm
       Solves: ax + by = gcd(a, b)
       Very useful for:
         - Finding modular inverse (when gcd(a, m) = 1)
         - Solving linear Diophantine equations

    ---------------------------------------------------------------
    4. LCM Formula:
       lcm(a, b) = (a / gcd(a, b)) * b
       ⚠️ Important: Divide before multiplying to avoid overflow

    ---------------------------------------------------------------
    5. Applications in CP:
       - Simplifying fractions (num/gcd, den/gcd)
       - Modular inverse with Extended Euclid
       - Problems involving periodicity (LCM)
       - GCD properties in arrays:
            gcd(a, b, c) = gcd(gcd(a, b), c)

===============================================================
*/

class GCD_LCM {

    // Recursive Euclidean Algorithm
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Iterative Euclidean Algorithm (faster in practice sometimes)
    static long gcdIterative(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM using GCD
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    /*
    Extended Euclidean Algorithm
    ----------------------------
    Finds x, y such that:
        a*x + b*y = gcd(a, b)

    Example: a=30, b=20
        gcd = 10
        One solution: x=1, y=-1
        Because 30*1 + 20*(-1) = 10

    Return array: [x, y, gcd]
    */
    static long[] extendedGCD(long a, long b) {
        if (b == 0) return new long[]{1, 0, a}; // (x=1, y=0, gcd=a)
        long[] vals = extendedGCD(b, a % b);
        long x = vals[1];
        long y = vals[0] - (a / b) * vals[1];
        return new long[]{x, y, vals[2]};
    }

    public static void main(String[] args) {
        long a = 30, b = 20;

        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
        System.out.println("LCM of " + a + " and " + b + " = " + lcm(a, b));

        long[] res = extendedGCD(a, b);
        System.out.println("Extended GCD result:");
        System.out.println("x = " + res[0] + ", y = " + res[1] + ", gcd = " + res[2]);
        // Verify: a*x + b*y should equal gcd
        System.out.println("Verification: " + (a * res[0] + b * res[1]));
    }
}

/*
===============================================================
⚡ Key Takeaways:
- gcd(a, b) via Euclid is O(log(min(a, b)))
- lcm(a, b) = (a / gcd(a, b)) * b
- Extended Euclid gives (x, y) for ax + by = gcd(a, b)
- Useful for modular inverse when modulus is NOT prime
===============================================================
*/

