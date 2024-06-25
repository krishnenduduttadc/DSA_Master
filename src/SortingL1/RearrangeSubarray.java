package SortingL1;

public class RearrangeSubarray {
    public static void main(String[] args) {
        // Hardcoded input values
        int n = 6;
        int s = 1;
        int e = 4;
        int[] arr = {10, 7, 8, 9, 1, 5}; // Example input

        // Calling the RearrangeSubArray method to process the subarray
        RearrangeSubArray(arr, s, e);

        // Printing the processed array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void RearrangeSubArray(int[] arr, int s, int e) {
        int p1 = s + 1;
        int p2 = e;
        while (p1 <= p2) {
            if (arr[p1] <= arr[s]) {
                p1++;
            } else if (arr[p2] > arr[s]) {
                p2--;
            } else {
                swap(arr, p1, p2);
                p1++;
                p2--;
            }
        }
        swap(arr, s, p2);
    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
