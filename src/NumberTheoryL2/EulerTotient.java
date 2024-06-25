package NumberTheoryL2;

import java.util.ArrayList;
import java.util.List;

public class EulerTotient {
    public static void main(String[] args) {
        int n = 12; // Fixed input

        List<Integer> coprimeNumbers = getCoprimeNumbers(n);

        System.out.println("Coprime numbers between 1 and " + n + ": " + coprimeNumbers);
        System.out.println("Number of coprime numbers: " + coprimeNumbers.size());
    }

    // Function to calculate Euler's Totient function (phi) for a given number n
    public static int eulerTotient(int n) {
        int result = n;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    // Function to find and return coprime numbers between 1 and n
    public static List<Integer> getCoprimeNumbers(int n) {
        List<Integer> coprimeNumbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (gcd(i, n) == 1) {
                coprimeNumbers.add(i);
            }
        }

        return coprimeNumbers;
    }

    // Function to calculate the greatest common divisor (GCD) of two numbers a and b
    public static int gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
