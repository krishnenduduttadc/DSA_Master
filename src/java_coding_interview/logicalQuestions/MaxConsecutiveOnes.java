package java_coding_interview.logicalQuestions;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(findmax(arr));
    }

    static int findmax(int[] nums) {
        int cons = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cons++;
                max = Math.max(max, cons);
            } else {
                cons = 0;
            }
        }
        return max;
    }
}
