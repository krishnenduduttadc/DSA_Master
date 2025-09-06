package CodeChef_java_coding_interview.logicalQuestions;

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int res = minMoves(arr);
        System.out.println(res);
    }

    public static int minMoves(int[] nums) {
        int i = 0;
        int min = nums[0];
        int result = 0;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (i = 0; i < nums.length; i++) {
            result += nums[i] - min;
        }
        return result;
    }
}
