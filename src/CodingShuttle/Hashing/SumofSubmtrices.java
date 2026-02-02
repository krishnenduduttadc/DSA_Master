package CodingShuttle.Hashing;

import java.util.HashMap;
import java.util.Map;

public class SumofSubmtrices {
    public static void main(String[] args) {
        int[][] a = {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2}
        };
        System.out.println(countMatricesWithGivenSum(a, 12));
    }

    static int countMatricesWithGivenSum(int[][] a, int target) {
        int rows = a.length;
        int cols = a[0].length;
        // Preprocessing
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                a[i][j] += a[i][j - 1];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < cols; j++) {
                int sum = 0;
                map.clear();
                map.put(0, 1);
                for (int k = 0; k < rows; k++) {
                    sum += (a[k][j] - (i > 0 ? a[k][i - 1] : 0));
                    int freq = map.getOrDefault(sum - target, 0);
                    ans += freq;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
}
