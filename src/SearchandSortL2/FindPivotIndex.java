package SearchandSortL2;

public class FindPivotIndex {
    public static void main(String[] args) {
        int arr[] = {1, 7, 3, 6, 5, 6};
        System.out.println(pivot_index(arr));
    }

    static int pivot_index(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int lsum = 0;
        int rsum = sum;

        for (int i = 0; i < arr.length; i++) {
            rsum = rsum - arr[i];
            if (lsum == rsum) {
                return i;
            }
            lsum += arr[i];
        }
        return -1;
    }
}
