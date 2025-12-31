/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author krish
 */
public class DistinctElementsWindowsofSizeK {
    public static List<Integer> countDistinct(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            // acquire
            freq.put(arr[end], freq.getOrDefault(arr[end], 0) + 1);

            // when window size reaches k
            if (end - start + 1 == k) {
                result.add(freq.size());

                // release
                int count = freq.get(arr[start]);
                if (count == 1) {
                    freq.remove(arr[start]);
                } else {
                    freq.put(arr[start], count - 1);
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 6, 3, 2, 3, 2, 4, 5, 2, 2, 2, 2, 3, 6};
        int k = 4;
        System.out.println(countDistinct(arr, k));
    }
}
