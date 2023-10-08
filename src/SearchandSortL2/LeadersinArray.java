package SearchandSortL2;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersinArray {
    public static ArrayList<Integer> leaders(int[]arr) {
        ArrayList<Integer>ans = new ArrayList<>();
        int r = Integer.MIN_VALUE;

        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] >= r){
                ans.add(arr[i]);
                r = arr[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[]args) {
        int[]arr = {16,17,5,4,3,5,2};
        ArrayList<Integer>ans = leaders(arr);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
