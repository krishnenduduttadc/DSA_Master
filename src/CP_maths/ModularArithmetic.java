package CP_maths;


class ModularArithmetic {
    /*
    ===============================================================
        MODULAR ARITHMETIC (Toolkit for Competitive Programming)
    ===============================================================

    ⚡ Why Modular Arithmetic?
    - Numbers in CP grow very large → overflow
    - Many problems ask results "mod 1e9+7" or another prime
    - Operations (add, subtract, multiply, divide) must respect mod

    ---------------------------------------------------------------
    1. Modular Addition
       (a + b) mod m = ((a mod m) + (b mod m)) mod m

       Example:
         a=1e9+6, b=5, m=1e9+7
         (a+b)%m = (1000000006+5)%1000000007 = 4

    ---------------------------------------------------------------
    2. Modular Subtraction
       (a - b) mod m = ((a mod m) - (b mod m) + m) mod m
       → "+m" ensures positivity

       Example:
         (5-7) mod 1e9+7
         = (5-7+1e9+7) % 1e9+7 = (1000000005) % 1e9+7 = 1000000005

    ---------------------------------------------------------------
    3. Modular Multiplication
       (a * b) mod m = ((a mod m) * (b mod m)) mod m

       Example:
         (1e9 * 1e9) mod 1e9+7
         = (1000000000 * 1000000000) % 1000000007
         = 49

    ---------------------------------------------------------------
    4. Modular Exponentiation (Fast Power)
       Compute a^b mod m efficiently in O(log b)
       → repeatedly square base, halve exponent

       Example:
         2^10 mod 1e9+7
         = 1024

    ---------------------------------------------------------------
    5. Modular Inverse
       We need "division mod m", i.e., a^(-1) such that:
         (a * a^(-1)) ≡ 1 (mod m)

       Two ways:
       (a) Fermat’s Little Theorem (only if m is prime):
           a^(m-1) ≡ 1 (mod m) → a^(m-2) ≡ a^(-1) (mod m)
       (b) Extended Euclidean Algorithm (works if gcd(a,m)=1)

       Example:
         Find inverse of 3 mod 11
         Solve 3x ≡ 1 (mod 11)
         → x=4 since 3*4=12 ≡ 1 mod 11

    ---------------------------------------------------------------
    6. Extended GCD
       ax + by = gcd(a, b)
       Gives solution (x,y) for any integers a, b

    ---------------------------------------------------------------
    Summary of Usage in CP:
      - Addition / Subtraction / Multiplication → direct formulas
      - Exponentiation → fast power
      - Division → modular inverse
      - gcd/lcm with mod → extended gcd helps
    ===============================================================
    */

    static final long MOD = 1000000007; // typical prime modulus

    // Modular addition
    static long modAdd(long a, long b) {
        return (a % MOD + b % MOD) % MOD;
    }

    // Modular subtraction
    static long modSub(long a, long b) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    // Modular multiplication
    static long modMul(long a, long b) {
        return (a % MOD * b % MOD) % MOD;
    }

    // Fast exponentiation (a^b % MOD)
    static long modPow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    // Modular inverse (Fermat’s theorem, MOD must be prime)
    static long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    // Modular inverse using Extended Euclidean Algorithm
    // Works for any modulus if gcd(a,m)=1
    static long modInverseEEA(long a, long m) {
        long[] res = extendedGCD(a, m);
        long x = res[0];
        return (x % m + m) % m;
    }

    // Extended GCD (returns [x,y,gcd] such that ax+by=gcd)
    static long[] extendedGCD(long a, long b) {
        if (b == 0) return new long[]{1, 0, a};
        long[] vals = extendedGCD(b, a % b);
        long x = vals[1];
        long y = vals[0] - (a / b) * vals[1];
        return new long[]{x, y, vals[2]};
    }

    public static void main(String[] args) {
        System.out.println("Add: (1e9+6+5)%MOD = " + modAdd(1000000006, 5));
        System.out.println("Sub: (5-7)%MOD = " + modSub(5, 7));
        System.out.println("Mul: (1e9*1e9)%MOD = " + modMul(1000000000, 1000000000));
        System.out.println("Pow: 2^10 %MOD = " + modPow(2, 10));
        System.out.println("Inverse (Fermat): 3^(-1) mod 1e9+7 = " + modInverse(3));
        System.out.println("Inverse (EEA): 3^(-1) mod 11 = " + modInverseEEA(3, 11));
    }
}


