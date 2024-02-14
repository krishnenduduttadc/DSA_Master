/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HML1;

import java.util.HashSet;

/**
 *
 * @author krish
 */
public class Distinct {
    public static void main (String[] args) {
        int arr[] = new int[]{15, 16, 27, 27, 28, 15};
        int n = arr.length;
        
        System.out.println(countDistinct(arr, n));
    }

    private static int countDistinct(int[] arr, int n) {
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i =0;i<n;i++){
            h.add(arr[i]);
        }
        return h.size();
    }
}
