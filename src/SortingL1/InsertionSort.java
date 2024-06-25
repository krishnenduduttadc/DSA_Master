package SortingL1;

public class InsertionSort {
    static void insert(int arr[], int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                int t = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = t;
            } else {
                break;
            }
        }
    }

    // Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            insert(arr, i);
        }
    }
    public static void main(String[] args) {
        InsertionSort solution=new InsertionSort();
        // Hardcoded input array
        int[] arr = {5, 2, 9, 1, 5, 6}; // Example input
        int n = arr.length;

        // Sorting the array using insertion sort
        solution.insertionSort(arr, n);

        // Printing the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
