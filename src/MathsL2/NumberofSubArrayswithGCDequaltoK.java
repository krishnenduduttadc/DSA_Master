package MathsL2;


public class NumberofSubArrayswithGCDequaltoK {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;

        for (int sp = 0; sp < nums.length; sp++) {
            int ans = 0;
            for (int ep = sp; ep < nums.length; ep++) {
                ans = gcd(ans, nums[ep]);

                if (ans < k) {
                    break;
                }
                if (ans == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        NumberofSubArrayswithGCDequaltoK solution = new NumberofSubArrayswithGCDequaltoK();

        // Hard-coded input
        int[] nums = {2, 4, 6, 8, 3, 9};
        int k = 3;

        int result = solution.subarrayGCD(nums, k);
        System.out.println("Number of subarrays with GCD equal to " + k + ": " + result);
    }
}
