package CodeChef_java_coding_interview.logicalQuestions;

import java.util.HashMap;
import java.util.Map;

public class PearlsInaRow {
    public static void main(String[] args) {
        solve();

    }

    private static void solve() {
        int n = 7;
        int[] type = {1, 2, 1, 3, 1, 2, 1};
        Map<Integer, Integer> map = new HashMap<>();
        int prev_partion_ending_index, total_partitions;
        prev_partion_ending_index = -1;
        total_partitions = 0;
        int[] answer = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(type[i])) {
                total_partitions++;
                answer[count++] = prev_partion_ending_index + 2;
                answer[count++] = i + 1;
                prev_partion_ending_index = i;
                map = new HashMap<Integer, Integer>();

            } else {
                map.put(type[i], 1);
            }
        }

        if (count == 0) {
            System.out.println(-1);
            return;
        }

        if (answer[count - 1] != n) {
            answer[count - 1] = n;
        }
        System.out.println(total_partitions);

        for (int i = 0; i < count; i += 2) {
            System.out.println(answer[i] + " " + answer[i + 1]);
        }
    }
}
