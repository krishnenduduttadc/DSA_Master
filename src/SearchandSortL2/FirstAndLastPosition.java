package SearchandSortL2;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,4,5,5};
        int[] res=find(arr,5);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }
    }

    static int[] find(int[] arr, int target) {
        int[] ans = {-1, -1};
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == target) {
                ans[0] = mid;
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        lo = 0;
        hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == target) {
                ans[1] = mid;
                lo = mid + 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
