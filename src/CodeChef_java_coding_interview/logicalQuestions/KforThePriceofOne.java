package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class KforThePriceofOne {
    public static void main(String[] args) {
        int n = 8;
        int p = 11;
        int k = 2;
        int A[] = {1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.sort(A);
        int count1 = 0;
        int temp = p;
        for (int i = 1; i < n; i += 2) {
            if (temp >= A[i]) {
                count1 += 2;
                temp -= A[i];
            } else {
                break;
            }
        }

        temp = p;
        int count2 = 0;
        if (temp >= A[0]) {
            count2 = 1;
            temp -= A[0];
        }

        for (int i = 2; i < n; i += 2) {
            if (temp >= A[i]) {
                count2 += 2;
                temp -= A[i];
            } else {
                break;
            }
        }

        System.out.println(count1 + " " + count2);
        System.out.println(Math.max(count1, count2));
    }
}
