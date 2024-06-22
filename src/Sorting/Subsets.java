package Sorting;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totalno = (1 << n);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < totalno; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (checkBit(i, j)) {
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    // Helper function to check if the i-th bit in n is set
    public boolean checkBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Subsets solution = new Subsets();

        // Hardcoded input array
        int[] nums = {1, 2, 3}; // Example input

        // Calling subsets to generate all subsets of the array
        List<List<Integer>> subsets = solution.subsets(nums);

        // Printing all subsets
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
