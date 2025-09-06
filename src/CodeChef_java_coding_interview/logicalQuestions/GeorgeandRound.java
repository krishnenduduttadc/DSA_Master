package CodeChef_java_coding_interview.logicalQuestions;

import java.util.HashSet;

public class GeorgeandRound {
    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        long[] A = {1, 2, 3};
        long[] B = {1, 1, 1, 1, 1};

        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            long v = B[i];
            if (set.contains(v)) {
                set.remove(v);
            }
        }
        answer = set.size();
        System.out.println(answer);
    }
}
