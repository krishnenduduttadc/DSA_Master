package MathsL2;

public class ArrMod_m {
    public static void main(String[] args) {
        // Hardcoded input array
        int[] arr = {3, 1, 4, 1, 5}; // Example input

        int n = arr.length;
        long num = 0;
        long mult = 1;
        int p = 1000000007;

        for (int i = n - 1; i >= 0; i--) {
            num = (num % p + ((arr[i] % p) * (mult % p)) % p) % p;
            mult = (mult * 10) % p;
        }

        System.out.println(num);
    }
}
