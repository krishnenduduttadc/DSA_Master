package SearchandSortL2;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> findClosest(int[]arr,int k,int x) {
        int lo = 0;
        int hi = arr.length - 1;

        while(hi - lo >= k){
            if(Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)){
                lo++;
            } else {
                hi--;
            }
        }

        List<Integer> r = new ArrayList<>(k);
        for(int i = lo; i <= hi; i++){
            r.add(arr[i]);
        }

        return r;
    }

    public static void main(String[]args) {

        //input work
        int[]arr = {10,20,30,40,50,60};

        int k = 3;
        int x = 45;
        List<Integer> ans = findClosest(arr,k,x);
        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}
