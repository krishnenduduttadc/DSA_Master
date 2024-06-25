package SortingL1;

public class SortPartiallySortedArray {
    public static void main(String[] args) {
        // Hardcoded input array
        int[] arr = {3, 1, 4, 1, 5}; // Example input

        // Calling the insertElement method to process the array
        insertElement(arr);

        // Printing the processed array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertElement(int[] arr) {
        int n = arr.length;
        for (int j = n - 2; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            } else {
                break;
            }
        }
    }
}
