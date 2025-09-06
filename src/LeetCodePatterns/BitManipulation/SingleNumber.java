package LeetCodePatterns.BitManipulation;

public class SingleNumber {
    // Main method to test the program
    public static void main(String[] args) {
        SingleNumber solver = new SingleNumber();

        int[] nums1 = {2, 2, 1};
        System.out.println("Single number in [2,2,1]: " + solver.singleNumber(nums1));

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single number in [4,1,2,1,2]: " + solver.singleNumber(nums2));

        int[] nums3 = {1};
        System.out.println("Single number in [1]: " + solver.singleNumber(nums3));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num; // XOR cancels out duplicate numbers
        }
        return ans;
    }

}
