package Sorting;

import java.util.Arrays;

public class GoodIntegersDuplicate {
    public static void main(String[] args) {

        int n =7;

        int[] arr = {0,1,5,7,8,9,4};

        System.out.println(GoodIntegers(arr));
    }

    public static int GoodIntegers(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int ans =0;
        int lesscount = 0;

        if(arr[0] == 0){
            ans++;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                lesscount = i;
            }

            if(arr[i] == lesscount){
                ans++;
            }
        }

        return ans;
    }

}
