package java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class ReachMedian {
    public static void main(String[] args) {
        int n = 7;
        long reqd = 10;
        long[] arr = {21, 15, 12, 11, 20, 19, 12};
        int i = 0;

        Arrays.sort(arr);
        long x = arr[n / 2];
        long sum = 0;

        if (x < reqd) {
            for (i = n / 2; i < n; i++) {
                if (arr[i] >= reqd) {
                    break;
                }
                sum += reqd - arr[i];
            }
        } else {
            for (i = n / 2; i >= 0; i--) {
                if (arr[i] <= reqd) {
                    break;
                }
                sum += arr[i] - reqd;
            }
        }

        System.out.println(sum);
    }
}
