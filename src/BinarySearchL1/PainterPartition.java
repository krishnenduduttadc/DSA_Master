package BinarySearchL1;

public class PainterPartition {
    static long minTime(int[] weights, int n, int days) {
        long maxWeight = weights[0];
        long totalWeight = weights[0];
        for (int i = 1; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            totalWeight += weights[i];
        }
        long low = maxWeight;
        long high = totalWeight;
        long ans = totalWeight;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long requiredDays = calculate(weights, mid);
            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static long calculate(int[] weights, long maxCapacity) {
        long days = 1;
        long sum = 0;
        for (int weight : weights) {
            if (sum + weight > maxCapacity) {
                days++;
                sum = 0;
            }
            sum += weight;
        }
        return days;
    }

    public static void main(String[] args) {
        // Hardcoded input for testing
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // Calculate and print the minimum weight capacity
        long result = minTime(weights, weights.length, days);
        System.out.println("Minimum weight capacity required: " + result);
    }
}
