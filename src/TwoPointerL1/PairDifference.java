package TwoPointerL1;


import java.util.Arrays;

public class PairDifference {
    public static void main(String[] args) {
        // Hardcoded input array and target difference
        int[] arr = {1, 8, 30, 40, 100};
        int n = 60;

        // Create an instance of the Solution class
        PairDifference solution = new PairDifference();

        // Call findPair to check if the pair exists
        boolean result = solution.findPair(arr, arr.length, n);

        // Print the result
        System.out.println("Pair with difference " + n + " exists: " + result);
    }

    public boolean findPair(int arr[], int size, int n) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while (i < size && j < size) {
            if (i != j && arr[j] - arr[i] == n) {
                return true;
            } else if (arr[j] - arr[i] > n) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
