package TwoPointer;

import RecursionAndBacktrackingL1.Solution;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, k = n-1;
        while(j<=k){
            if(nums[j] == 0){
                swap(nums,i,j);
                j++;
                i++;
            } else if(nums[j] == 1){
                j++;
            } else {
                swap(nums,j,k);
                k--;
            }
        }
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Hardcoded input array
        int[] arr = {0, 1, 2, 0, 1, 2, 1, 0, 2, 1};

        // Print the original array
        System.out.println("Original array: " + Arrays.toString(arr));

        // Create an instance of the Solution class
        SortColors solution = new SortColors();

        // Call sortColors to sort the array
        solution.sortColors(arr);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
