package BinarySearch1;

public class FloorinaSortedArray {
    public static void main(String[] args) {
        int[] arr = {0,1,5,7,8,9};

        int k = 3;
        System.out.println(Floor(arr,k));
    }

    public static int Floor(int[] arr, int k){
        int lo = 0;
        int hi = arr.length - 1;
        int ans = Integer.MIN_VALUE;

        while(lo <= hi){
            int m = (lo+hi)/2;

            if(arr[m] == k){
                return k;
            }else if(arr[m] < k){
                ans = arr[m];
                lo = m + 1;
            }else{
                hi = m-1;
            }
        }

        return ans;
    }

}
