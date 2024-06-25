package ArraysL3;



public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int pf1 = 1;
        int max1 = Integer.MIN_VALUE;
        int pf2 = 1;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pf1 == 0) {
                pf1 = nums[i];
            } else {
                pf1 = pf1 * nums[i];
            }
            max1 = Math.max(max1, pf1);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (pf2 == 0) {
                pf2 = nums[i];
            } else {
                pf2 = pf2 * nums[i];
            }
            max2 = Math.max(max2, pf2);
        }

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        MaxProductSubarray solution = new MaxProductSubarray();
        int arr[] = {2, 3, -2, 4};

        int result = solution.maxProduct(arr);
        System.out.println("Maximum product of subarray: " + result); // Expected output: 6 (subarray [2, 3])
    }
}
