package SortingL1;

import java.util.Arrays;

public class GoodIntegersDistinct {
    public static void main(String[] args) {
        int n = 7;

        int[] arr = {0,1,5,7,8,9,4};

        System.out.println(GoodIntegers(arr));

    }

    public static int GoodIntegers(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int ans =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == i){
                ans++;
            }
        }

        return ans;
    }

}
