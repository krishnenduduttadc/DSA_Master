package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class SoldierAndBadges {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int n = 5;
        int[] arr = {1, 2, 3, 2, 5};
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    count++;
                    arr[j]++;
                }
                System.out.println(count);
            }
        }
    }
}
