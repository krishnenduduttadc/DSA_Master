package SearchandSortL2;

import java.util.Arrays;

public class CountPossibleTraingles {
    public static int countTriangles(int[]arr) {
        //write your code here
        Arrays.sort(arr);
        int c = 0;

        for(int i = arr.length - 1; i >= 2; i--){
            int l = 0;
            int r = i - 1;

            while(l < r) {
                if(arr[l] + arr[r] > arr[i]){
                    c = c + r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return c;
    }

    public static void main(String[]args) {
        //input work
        int n = 5;

        int[]arr = {6,4,9,2,8};

        System.out.println(countTriangles(arr));
    }
}
