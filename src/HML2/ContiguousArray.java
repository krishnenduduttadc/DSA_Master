package HML2;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        System.out.println(sol(arr));
    }

    private static int sol(int[] arr) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum += -1;
            } else if (arr[i] == 1) {
                sum += +1;
            }

            if (map.containsKey(sum)) {
                int idx = map.get(sum);
                int len = i - idx;
                if (len > ans) {
                    ans = len;
                }
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
