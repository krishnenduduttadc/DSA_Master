package SearchandSortL2;

import java.util.Arrays;

public class ChocolateDistribution {
    public static int find(int[]arr, int n, int m) {
        //write your code here
        int a = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i = 0; i <= n - m; i++){
            int minw = arr[i];
            int maxw = arr[i + m - 1];
            int g = maxw - minw;
            if(g < a){
                a = g;
            }
        }

        return a;
    }

    public static void main(String[]args) {

        int n = 8;
        int[]arr = {3,4,1,9,56,7,9,12};

        int m = 5;
        int ans = find(arr, n, m);

        System.out.println(ans);
    }
}
