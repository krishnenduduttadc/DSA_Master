package Sorting;

public class QuickSort {
    static void quickSort(int arr[], int s, int e) {
        if (s >= e) return;
        int p = rearrange(arr, s, e);
        quickSort(arr, s, p - 1);
        quickSort(arr, p + 1, e);
    }

    static int rearrange(int[] arr, int s, int e) {
        int p1 = s + 1;
        int p2 = e;
        while (p1 <= p2) {
            if (arr[p1] <= arr[s]) p1++;
            else if (arr[p2] > arr[s]) p2--;
            else {
                swap(arr, p1, p2);
                p1++;
                p2--;
            }
        }
        swap(arr, s, p2);
        return p2;
    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    public static void main(String[] args) {
        // Hardcoded input array
        int[] arr = {10, 7, 8, 9, 1, 5}; // Example input
        int n = arr.length;

        // Calling quickSort to sort the entire array
        quickSort(arr, 0, n - 1);

        // Printing the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
