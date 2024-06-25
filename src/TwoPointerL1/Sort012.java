package TwoPointerL1;

import java.util.Arrays;

public class Sort012 {

        public static void sort012(int arr[], int n)
        {
            int i = 0, j = 0, k = n-1;
            while(j<=k){
                if(arr[j] == 0){
                    swap(arr,i,j);
                    j++;
                    i++;
                } else if(arr[j] == 1){
                    j++;
                } else {
                    swap(arr,j,k);
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

        // Call sort012 to sort the array
        sort012(arr, arr.length);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

}
