package BinarySearch1;

import RecursionAndBacktrackingL1.Solution;

public class CapcityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = weights[0];
        int totalWeight = weights[0];
        for (int i = 1; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            totalWeight += weights[i];
        }
        int low = maxWeight;
        int high = totalWeight;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int requiredDays = calculateDays(weights, mid);
            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int calculateDays(int[] weights, int maxWeight) {
        int days = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > maxWeight) {
                days++;
                sum = 0;
            }
            sum += weight;
        }
        return days;
    }

    public static void main(String[] args) {
        CapcityToShipPackages solution = new CapcityToShipPackages();

        // Hardcoded input
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // Calculate and print the minimum ship capacity
        int result = solution.shipWithinDays(weights, days);
        System.out.println("Minimum ship capacity required: " + result);
    }
}
