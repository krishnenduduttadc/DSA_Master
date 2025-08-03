package ArraysL2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MajorityElementGeneral {
    //~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]) == true) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > n / k) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }

    //~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 2, 5, 1, 4, 3, 2};
        int k = 10;
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}
