package ArraysL2;

public class MaximumAverageSubarray {
    public static double solution(int nums[], int k) {
        // write your code here
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum = sum + nums[i];
        }

        int max = sum;

        for(int i = k; i < nums.length; i++){
            sum = sum + nums[i];
            sum = sum - nums[i - k];
            max = Math.max(max,sum);
        }

        return (max * 1.0) / k;
    }
    public static void main(String[] args) {
        int nums[] = {-10,5,-6,8,-7,2,-4,8,-6,7};
        int k = 3;
        System.out.println(solution(nums, k));
    }
}
