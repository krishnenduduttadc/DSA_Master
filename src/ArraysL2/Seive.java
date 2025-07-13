package ArraysL2;

import java.util.Arrays;

public class Seive {
    static void seive(int n) {
        boolean[] isprime = new boolean[n + 1];
        Arrays.fill(isprime, true);

        isprime[0] = isprime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isprime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isprime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        seive(20);
    }
}
