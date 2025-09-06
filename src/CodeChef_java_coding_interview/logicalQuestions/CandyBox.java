package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class CandyBox {
    public static void main(String[] args) {
        int n = 9;
        int[] a = {1, 2, 2, 3, 3, 3, 4, 4, 4};
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            ++temp[a[i] - 1];
        }
        Arrays.sort(temp);

        for (int i = n - 2; i >= 0; i--) {
            if (temp[i] >= temp[i + 1]) {
                temp[i] = Math.max(temp[i + 1] - 1, 0);
            }
        }

        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            result += temp[i];
        }
        System.out.println(result);
    }
}
