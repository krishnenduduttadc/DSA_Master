package SortingL1;


public class MergeSort {
    void merge(int arr[], int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int p3 = 0;

        while (p1 <= m && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                temp[p3] = arr[p1];
                p1++;
            } else {
                temp[p3] = arr[p2];
                p2++;
            }
            p3++;
        }

        while (p1 <= m) {
            temp[p3] = arr[p1];
            p1++;
            p3++;
        }

        while (p2 <= r) {
            temp[p3] = arr[p2];
            p2++;
            p3++;
        }

        int i = l;
        int j = 0;

        while (j < temp.length) {
            arr[i] = temp[j];
            i++;
            j++;
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array:");
        printArray(arr);

        solution.mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
