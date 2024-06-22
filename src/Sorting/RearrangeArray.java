package Sorting;

public class RearrangeArray {
    public static void main(String[] args) {
        // Hardcoded input array
        int[] arr = {10, 7, 8, 9, 1, 5}; // Example input
        int n = arr.length;

        // Calling the rearrange method to process the array
        rearrange(arr);

        // Printing the processed array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void rearrange(int[] arr) {
        int n = arr.length;
        int p1 = 1;
        int p2 = n - 1;
        while (p1 <= p2) {
            if (arr[p1] <= arr[0]) {
                p1++;
            } else if (arr[p2] > arr[0]) {
                p2--;
            } else {
                swap(arr, p1, p2);
                p1++;
                p2--;
            }
        }
        swap(arr, 0, p2);
    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
