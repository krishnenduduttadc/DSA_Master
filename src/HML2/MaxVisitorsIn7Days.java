package HML2;

import java.util.HashMap;

public class MaxVisitorsIn7Days {
    public static void main(String[] args) {
        int[] visitors = {10, 15, 20, 18, 25, 25, 25, 25, 25, 19, 23, 28, 31};
        int k = 7; // Window size

        int maxVisitors = findMaxVisitors(visitors, k);
        System.out.println("Maximum visitors in any contiguous 7-day period: " + maxVisitors);
    }

    public static int findMaxVisitors(int[] arr, int k) {
        int maxVisitors = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= k - 2; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = k - 1, j = 0; i < arr.length; i++, j++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            int max = Integer.MIN_VALUE;
            for (int m : map.keySet()) {
                if (map.get(m) > max) {
                    max = map.get(m);
                }
            }
            maxVisitors=Math.max(maxVisitors,max);

            // Release old element
            if (map.get(arr[j]) == 1) {
                map.remove(arr[j]);
            } else {
                map.put(arr[j], map.get(arr[j]) - 1);
            }
        }
        return maxVisitors;
    }
}
