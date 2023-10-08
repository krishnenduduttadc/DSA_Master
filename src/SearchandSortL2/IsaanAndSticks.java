package SearchandSortL2;

import java.util.ArrayList;
import java.util.HashMap;

public class IsaanAndSticks {
    public static ArrayList<Integer>  solve(int[]arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : arr){
            if(map.containsKey(ele) == true){
                int nf = map.get(ele) + 1;
                map.put(ele, nf);
            } else {
                map.put(ele, 1);
            }
        }

        int m = 0;
        int sq = 0;

        for(int key : map.keySet()) {
            int freq = map.get(key);

            if(freq >= 4){
                int a = key * key;

                if(a > m){
                    m = a;
                    sq = freq / 4;
                }
            }
        }

        ArrayList<Integer> a = new ArrayList<>();
        if(m == 0){
            a.add(-1);
        } else {
            a.add(m);
            a.add(sq);
        }

        return a;
    }

    public static void main(String[]args) {

        int[]arr = {2,3,2,3,2,3,3,3,2,3,3,3,4};

        ArrayList<Integer> ans = solve(arr);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
