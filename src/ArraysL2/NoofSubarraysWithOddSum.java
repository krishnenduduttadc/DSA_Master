package ArraysL2;

public class NoofSubarraysWithOddSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(nos(arr));
    }

    static int nos(int[] arr) {
        long ans = 0;
        int even = 0;
        int odd = 0;
        int sum = 0;

        for (int val : arr) {
            sum += val;
            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += 1 + even;
                odd++;
            }
        }
        return (int)(ans%1000000007);
    }
}
