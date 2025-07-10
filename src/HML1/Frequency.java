/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author krish
 */
public class Frequency {
    public static void main(String[] args) {
        //int arr[] = new int[]{15, 16, 27, 27, 28, 15};
        int arr[] = new int[]{2, 2, 3, 4, 3, 5, 6
        };
        int n = arr.length;

        countFreq(arr, n);
    }

    static void countFreq(int arr[], int n) {
        Map<Integer, Integer> hmp = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            if (hmp.containsKey(arr[i]) == true)
                hmp.put(arr[i], hmp.get(arr[i]) + 1);
            else
                hmp.put(arr[i], 1);
        }

        for (Map.Entry<Integer, Integer> itr : hmp.entrySet())
            System.out.println(itr.getKey() + " " + itr.getValue());
    }
}
