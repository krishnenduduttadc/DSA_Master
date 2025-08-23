package SlidingWindowL1;

public class MaxSumSubarrayK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int windowSum = 0, maxSum = 0;

        for (int i = 0; i < k; i++) windowSum += arr[i];
        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("Max sum of subarray of size " + k + " = " + maxSum);
    }
}

