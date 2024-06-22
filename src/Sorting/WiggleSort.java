package Sorting;

import RecursionAndBacktrackingL1.Solution;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    // Helper function to swap elements in an array
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        WiggleSort solution = new WiggleSort();

        // Hardcoded input array
        int[] nums = {3, 5, 2, 1, 6, 4}; // Example input

        // Calling wiggleSort to rearrange the array
        solution.wiggleSort(nums);

        // Printing the wiggle sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
