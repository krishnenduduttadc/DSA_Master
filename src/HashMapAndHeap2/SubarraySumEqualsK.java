package HashMapAndHeap2;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int arr[] = {3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1};
        int k = 5;
        System.out.println(sol(arr, k));
    }

    private static int sol(int[] arr, int target) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            int rsum = sum - target;
            if (map.containsKey(rsum)) {
                ans = ans + map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
