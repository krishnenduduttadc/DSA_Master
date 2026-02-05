package DPL2;

public class LIS {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        int n = arr.length;
        int[] dp = new int[n];
        int omax = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;

            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        System.out.print(omax + " ");

        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }

    }
}
