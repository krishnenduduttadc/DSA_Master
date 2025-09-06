package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class PhoebeandHerFitnessClass {
    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        int arr[] = {6, 1, 3};
        Arrays.sort(arr);
        int flag = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + k > arr[i + 1] - k) {
                System.out.println("Imperfect");
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Perfect");
        }
    }
}
