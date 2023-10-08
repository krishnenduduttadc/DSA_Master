package SearchandSortL2;

public class FindMininuminRotatedSortedArray {
    public static int findMinimum(int[]arr) {
        //write your code here
        int lo = 0;
        int hi = arr.length - 1;

        if(arr[lo] <= arr[hi]){
            return arr[0];
        }

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            else if(arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            else if(arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            } else if(arr[lo] <= arr[mid]) {
                lo = mid + 1;
            } else if(arr[mid] <= arr[hi]) {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[]args) {
        //input work


        int[]arr = {4,5,6,7,8,0,1,3};


        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}
