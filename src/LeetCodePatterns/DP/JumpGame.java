package LeetCodePatterns.DP;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame solver = new JumpGame();

        int[] nums1 = {2, 3, 1, 1, 4};   // true
        int[] nums2 = {3, 2, 1, 0, 4};   // false
        int[] nums3 = {0};               // true

        System.out.println("Can jump [2,3,1,1,4]: " + solver.canJump(nums1));
        System.out.println("Can jump [3,2,1,0,4]: " + solver.canJump(nums2));
        System.out.println("Can jump [0]: " + solver.canJump(nums3));
    }

    public boolean canJump(int[] nums) {
        int maxReachable = nums[0];
        int i = 1;
        while (i < nums.length && maxReachable >= i) {
            if (i + nums[i] > maxReachable) {
                maxReachable = i + nums[i];
            }
            i++;
        }
        return maxReachable >= nums.length - 1;
    }
}
