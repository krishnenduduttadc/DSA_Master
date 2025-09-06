package CodeChef_java_coding_interview.logicalQuestions;

import java.util.ArrayList;

public class TreeOfLife {
    public static void main(String[] args) {
        int n = 3;
        int[][] input = {{1, 2}, {1, 3}, {1, 4}};
        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            int[] in = input[i];
            int a = in[0] - 1;
            int b = in[1] - 1;
            map[a].add(b);
            map[b].add(a);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long v = map[i].size();
            result += v * (v - 1) / 2;
        }
        System.out.println(result);
    }
}
