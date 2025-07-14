package SearchandSortL2;

public class FindTransition {
    public static int findTransition(int[] arr) {
        int tp = -1;
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == 1) {
                tp = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return tp;
    }

    public static void main(String[] args) {
        //input work
        int n = 6;
        int[] arr = {0, 0, 0, 0, 1, 1};
        System.out.println(findTransition(arr));
    }
}
