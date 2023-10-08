package SearchandSortL2;

public class AllocateMinNoofPages {
    public static int minPages(int[] arr, int m) {
        //write your code here
        int sum = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            max = Math.max(max, arr[i]);
        }

        int lo = max;
        int hi = sum;
        int a = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (i(arr, mid, m) == true) {
                a = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return a;

    }

    public static boolean i(int[] arr, int mid, int m) {
        int st = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            if (sum > mid) {
                st++;
                sum = arr[i];
            }
        }

        return st <= m;
    }

    public static void main(String[] args) {
        //input work

        int n = 4;

        int[] arr = {20, 10, 30, 40};
        int m = 3;

        int ans = minPages(arr, m);
        System.out.println(ans);
    }
}
