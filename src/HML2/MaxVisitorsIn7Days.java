package HML2;

public class MaxVisitorsIn7Days {
    public static void main(String[] args) {
        int[] visitors = {10, 15, 20, 18, 25, 25, 25, 25, 25, 19, 23, 28, 31};
        int k = 7; // Window size

        int maxVisitors = findMaxVisitors(visitors, k);
        System.out.println("Maximum visitors in any contiguous 7-day period: " + maxVisitors);
    }

    public static int findMaxVisitors(int[] arr, int k) {
        int sum = 0;
        int maxSum = 0;

        // Sum of first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        maxSum = sum;

        // Sliding window
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
