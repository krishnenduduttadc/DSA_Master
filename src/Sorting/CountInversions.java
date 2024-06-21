package Sorting;

public class CountInversions {
    static long ans;

    static long inversionCount(long arr[], long N) {
        ans = 0;
        mergeSort(arr, 0, arr.length - 1);
        return ans;
    }

    static void mergeSort(long arr[], int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(long arr[], int l, int m, int r) {
        long[] temp = new long[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int p3 = 0;
        while (p1 <= m && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                temp[p3] = arr[p1];
                p1++;
            } else {
                ans += (m - p1 + 1);
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

    public static void main(String[] args) {
        long[] arr = {2, 3, 8, 6, 1};
        long N = arr.length;

        System.out.println("Given Array:");
        printArray(arr);

        long inversionCount = inversionCount(arr, N);

        System.out.println("\nNumber of inversions: " + inversionCount);
    }

    static void printArray(long arr[]) {
        for (long num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
