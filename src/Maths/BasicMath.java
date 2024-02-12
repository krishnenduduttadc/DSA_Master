/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maths;

/**
 *
 * @author krishnendu
 */
public class BasicMath {

    public static void main(String a[]) {
        System.out.println(countDigits(123));
        System.out.println(countDigitsR(123));
        System.out.println(isPalindrome(12321));
        System.out.println(factI(5));
        System.out.println(factR(5));
        System.out.println(countTrailingZeroes(251));
        System.out.println(gcd(100, 200));
        System.out.println(gcdR(100, 200));
        System.out.println(lcm(100, 200));
        System.out.println(isPrime(14));
        System.out.println(power(2, 6));
        primefactors(91);

    }

    private static int countDigits(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n / 10;
            cnt++;
        }
        return cnt;
    }

    public static int countDigitsR(int n) {
        if (n == 0) {
            return 0;
        } else {
            return 1 + countDigitsR(n / 10);
        }
    }

    static boolean isPalindrome(int n) {
        int temp = n;
        int rev = 0;
        while (temp != 0) {
            int ld = temp % 10;
            rev = rev * 10 + ld;
            temp = temp / 10;
        }
        return (rev == n);
    }

    static int factI(int x) {
        int f = 1;
        for (int i = 2; i <= x; i++) {
            f = f * i;
        }
        return f;
    }

    static int factR(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factR(n - 1);
    }

    static int countTrailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = res + n / i;
        }
        return res;
    }

    static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    static int gcdR(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcdR(b, a % b);
        }
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int temp = power(x, n / 2);
        temp = temp * temp;
        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
    }

    static void primefactors(int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i+ " ");
                n = n / i;
            }
        }
        if (n > 1) {
            System.out.print(n);
        }
    }
}
