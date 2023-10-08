package SearchandSortL2;

public class SplitArrayLargestSum {
    public static int splitArray(int[]arr, int m) {
        int max = 0;
        int sum = 0;

        for(int val : arr) {
            sum = sum + val;
            max = Math.max(val, max);
        }

        if(m == arr.length) {
            return max;
        }

        int lo = max;
        int hi = sum;
        int ans = 0;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(I(arr,mid,m) == true) {
                ans = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public static boolean I(int[]arr,int mid,int m) {
        int sa = 1;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(sum > mid){
                sa++;
                sum = arr[i];
            }
        }

        return sa <= m;
    }

    public static void main(String[]args) {
        //input work

        int[]arr = {7,2,5,10,8};
        int m = 2;

        int ans = splitArray(arr, m);
        System.out.println(ans);
    }
}
