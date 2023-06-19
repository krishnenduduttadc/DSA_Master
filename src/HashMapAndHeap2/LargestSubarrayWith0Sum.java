/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMapAndHeap2;

import java.util.HashMap;

/**
 *
 * @author krish
 */
public class LargestSubarrayWith0Sum {

    public static void main(String[] args) {
        int arr[] = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        HashMap<Integer, Integer> hm = new HashMap<>(); //index,sum
        int i = -1;
        int sum = 0;
        hm.put(sum, i);
        int mlen = 0;

        while (i < arr.length - 1) {
            i++;
            sum = sum + arr[i];
            if (hm.containsKey(sum) == false) {
                hm.put(sum, i);
            } else {
                int len = i - hm.get(sum);
                if (len > mlen) {
                    mlen = len;
                }
            }

        }

        System.out.println(mlen);

    }

}
