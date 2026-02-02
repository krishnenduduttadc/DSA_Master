package CodingShuttle.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctWindowofSizeK {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 4, 4, 3};
        int k = 4;
        int[] ans = uniqueInEachWindow(a, k);
        for (int e : ans) {
            System.out.print(e + " ");
        }
    }

    static int[] uniqueInEachWindow(int[] a, int k) {
        int n = a.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize the map for the first window
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        // Process the rest of the windows
        for (int i = k; i < n; i++) {
            ans[i - k] = map.size();

            // Remove the left element of the previous window
            int left = i - k;
            int freqLeft = map.get(a[left]);
            if (freqLeft == 1) {
                map.remove(a[left]);
            } else {
                map.put(a[left], freqLeft - 1);
            }

            // Add the new element of the current window
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        // Add the result for the last window
        ans[n - k] = map.size();

        return ans;
    }
}
