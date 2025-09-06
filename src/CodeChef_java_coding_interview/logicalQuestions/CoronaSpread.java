package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class CoronaSpread {
    public static void main(String[] args) {
        int n = 9;
        int a[] = {1, 2, 5, 6, 7, 8, 9, 10, 11};
        int b[] = new int[n];
        for (int j = 0; j < n; j++) {
            b[j] = 1;
        }
        for (int j = 0; j < n; j++) {
            for (int k = j; k > 0; k--) {
                if (Math.abs(a[k] - a[k - 1]) <= 2) {
                    b[j]++;
                } else {
                    break;
                }
            }


            for (int k = j; k < n - 1; k++) {
                if (Math.abs(a[k] - a[k + 1]) <= 2) {
                    b[j]++;
                } else {
                    break;
                }
            }
        }

        Arrays.sort(b);
        System.out.println(b[0] + " " + b[b.length - 1]);
    }
}
