package HML2;

import java.util.HashMap;

public class RabbitsinForest {
    public static void main(String[] args) {
        int[] arr = {2,2,3,1,0,2,2,3,1};
        System.out.println(sol(arr));
    }

    private static int sol(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            int gs = key + 1;
            int reportees = map.get(key);
            int ng = (int) Math.ceil(reportees * 1.0 / gs * 1.0);
            ans += ng * gs;
        }
        return ans;
    }
}
