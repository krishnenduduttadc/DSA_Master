package SearchandSortL2;

import java.util.Arrays;

public class CountTheTriplets {
    public static int countTriplets(int[]arr) {
        //write your code here
        Arrays.sort(arr);
        int c = 0;

        for(int i = arr.length - 1; i >= 2 ; i--){
            int l = 0;
            int r = i - 1;

            while(l < r){
                if(arr[l] + arr[r] == arr[i]){
                    c++;
                    l++;
                    r--;
                } else if(arr[l] + arr[r] < arr[i]){
                    l++;
                } else {
                    r--;
                }
            }
        }

        return c;
    }

    public static void main(String[]args) {
        //input work
        int n = 6;

        int[]arr = {1,3,5,2,7,4};


        System.out.println(countTriplets(arr));
    }
}
