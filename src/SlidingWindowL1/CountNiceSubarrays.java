package SlidingWindowL1;

public class CountNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k)); // Output: 2
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int left = 0, count = 0, res = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) count++;
            while (count > k) {
                if (nums[left] % 2 == 1) count--;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}

