package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class VisitingToyStore {
    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        int N = 8;
        int[] arr = {4, -1, 2, 0, -8, -6, -4, -3};
        Arrays.sort(arr);
        int total = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] < 0 && arr[i + 1] < 0) {
                total = total * (arr[i] * arr[i + 1]);
                i = i + 1;
            }
            if (arr[i] > 0) {
                total = total * arr[i];
            }
        }
        System.out.println(total);
    }
}
