package DP1;

import RecursionAndBacktrackingL1.Solution;

public class LISBInarySearch {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int ans = 0;
            for(int i = 0; i<n; i++){
                int lo = 0, hi = ans;
                while(lo < hi){
                    int m = lo + (hi-lo)/2;
                    if(dp[m] < nums[i]){
                        lo = m+1;
                    } else {
                        hi = m;
                    }
                }
                dp[lo] = nums[i];
                if(lo == ans) ans++;
            }
            return ans;
        }

    public static void main(String[] args) {
        LISBInarySearch solution = new LISBInarySearch();

        // Test cases
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS for nums1: " + solution.lengthOfLIS(nums1));

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Length of LIS for nums2: " + solution.lengthOfLIS(nums2));

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Length of LIS for nums3: " + solution.lengthOfLIS(nums3));
    }

}
