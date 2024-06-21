package BitManipulation2;

public class SingleNUmber {
    public static void main(String[] args) {
        SingleNUmber solution = new SingleNUmber();

        // Test case 1
        int[] nums1 = {2, 2, 3, 2};
        int result1 = solution.singleNumber(nums1);
        System.out.println("Single number in nums1: " + result1); // Expected output: 3
    }


    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (checkBit(nums[j], i) == true) {
                    count++;
                }
            }

            if (count % 3 == 1) {
                ans = ans + (1 << i);
            }
        }

        return ans;
    }

    public boolean checkBit(int n, int i) {
        if ((n & (1 << i)) == 0) {
            return false;
        } else {
            return true;
        }
    }

}
