package CodeChef_java_coding_interview.logicalQuestions;

public class AandBandCompilationErrors {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {1, 5, 8, 123, 7};
        int[] arr2 = {123, 7, 5, 1};
        int[] arr3 = {5, 1, 7};

        long sum = 0, sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum += arr1[i];
        }

        for (int i = 0; i < n - 1; i++) {
            sum1 += arr2[i];
        }

        for (int i = 0; i < n - 2; i++) {
            sum2 += arr3[i];
        }

        System.out.println(sum - sum1);
        System.out.println((sum1 - sum2));
    }
}
