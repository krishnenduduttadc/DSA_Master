package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class BusinessTrip {
    public static void main(String[] args) {
        int k = 11;
        int[] a = {1, 1, 4, 1, 1, 5, 1, 1, 4, 1, 1, 1};
        int sum = Arrays.stream(a).sum();
        int count = 0;
        if (k == 0) {
            System.out.println(0);
        } else if (sum < k) {
            System.out.println(-1);
        } else if (sum == k) {
            for (int i = 0; i < 12; i++) {
                count += a[i] > 0 ? 1 : 0;
            }
            System.out.println(count);
        } else {
            Arrays.sort(a);
            for (int i = 11; i >= 0; i--) {
                if (k <= 0) {
                    break;
                } else {
                    k = k - a[i];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
