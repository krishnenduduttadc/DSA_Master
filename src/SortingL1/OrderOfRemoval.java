package SortingL1;

import java.util.Arrays;

public class OrderOfRemoval {
    public static void main(String[] args) {
        int n = 5;

        int[] arr = {1,2,3,4,5};

        System.out.println(orderOfRemoval(arr));

    }

    public static int orderOfRemoval(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int ans =0;

        for(int i=0;i<arr.length;i++){
            int temp = arr[i] * (n-i);
            ans = ans + temp;
        }

        return ans;
    }

}
