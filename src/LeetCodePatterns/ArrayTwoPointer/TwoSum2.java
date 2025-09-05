package LeetCodePatterns.ArrayTwoPointer;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
        TwoSum2 solution = new TwoSum2();

        int[] numbers1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(numbers1, 9)));
        // Expected: [1, 2]
    }

    public int[] twoSum(int[] numbers, int target) {
        int f = 0, s = numbers.length - 1;
        int[] ans = new int[2];

        while (f < s) {
            int sum = numbers[f] + numbers[s];
            if (sum < target) {
                f++;
            } else if (sum > target) {
                s--;
            } else {
                ans[0] = f + 1;
                ans[1] = s + 1;
                break;
            }
        }
        return ans;
    }
}
