package SearchandSortL2;

import java.util.Arrays;

public class LargestNumber {
    public static String largestNumber(int[]nums) {
        //write your code here
        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }

        Arrays.sort(arr, (a, b)->{
            long n1 = Long.parseLong(a + b);
            long n2 = Long.parseLong(b + a);

            if(n1 > n2){
                return 1;
            } else if (n1 < n2){
                return -1;
            } else {
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder("");

        for(int i = arr.length - 1; i >= 0; i--){
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[]args) {
        int[]nums = {3,7,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
