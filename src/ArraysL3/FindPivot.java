package ArraysL3;

public class FindPivot {
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int idx = -1;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            if (currSum == totalSum - currSum - nums[i]) {
                idx = i;
                break;
            }
            currSum += nums[i];
        }
        return idx;
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 3, 4, 3};
        System.out.println(pivotIndex(arr));
    }
}
