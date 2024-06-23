package HML1;

import java.util.Arrays;
import java.util.HashMap;

public class SameDifference {
    public static void main(String[] args) {
        // Example hardcoded input
        int[][] inputs = {
                {5, 3, 1, 4, 7},
                {4, 2, 4, 2},
                {6, 5, 5, 5, 5, 5}
        };

        for (int[] arr : inputs) {
            int n = arr.length;
            System.out.println("Input array: " + Arrays.toString(arr));
            System.out.println("Result: " + sameDifference(arr, n));
            System.out.println();
        }
    }

    public static int sameDifference(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int diff = arr[j] - j;
            ans += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return ans;
    }
}
