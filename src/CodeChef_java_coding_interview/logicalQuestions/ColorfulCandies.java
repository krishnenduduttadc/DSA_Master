package CodeChef_java_coding_interview.logicalQuestions;

import java.util.HashMap;

public class ColorfulCandies {
    public static void main(String[] args) {
        int N = 8;
        int K = 5;
        int[] candy = {1, 2, 1, 2, 3, 4, 2, 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int result = 0;
        int current = 0;

        for (int left = 0; left < N - K + 1; left++) {
            while (right - left < K) {
                int color = candy[right];
                int num = map.getOrDefault(color, 0);
                if (num == 0) {
                    current++;
                }
                map.put(color, num + 1);
                right++;
            }

            result = Math.max(result, current);
            int color = candy[left];
            int num = map.get(color);
            if (num == 1) {
                current--;
            }
            map.put(color, num - 1);
        }
        System.out.println(result);
    }
}
