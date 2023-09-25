package HML2;

import java.util.HashMap;

public class LongestSubarraywithEqual0s1sand2s {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 0, 1, 0, 1, 2, 1, 2, 2, 0, 1};
        System.out.println(sol(arr));
    }

    private static int sol(int[] arr) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int countz = 0;
        int counto = 0;
        int countt = 0;
        int delta10 = counto - countz;
        int delta21 = countt - counto;
        String key = delta21 + "#" + delta10;
        map.put(key, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countz++;
            } else if (arr[i] == 1) {
                counto++;
            } else {
                countt++;
            }

            delta10 = counto - countz;
            delta21 = countt - counto;
            key = delta21 + "#" + delta10;

            if (map.containsKey(key)) {
                int idx = map.get(key);
                int len = i - idx;
                if (len > ans) {
                    ans = len;
                }
            } else {
                map.put(key, i);
            }
        }
        return ans;
    }
}
