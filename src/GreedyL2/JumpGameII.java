package GreedyL2;

//Find minimum number of jumps to reach last index.
public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        int jumps = 0, curEnd = 0, farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = farthest;
            }
        }

        System.out.println("Min jumps = " + jumps);
    }
}

