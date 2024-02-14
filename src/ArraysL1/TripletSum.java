/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

import java.util.*;

/**
 *
 * @author krish
 */
public class TripletSum {

    public static int tripletSum(int[] arr, int sum) {
        //Your code goes here
        int p=0,q=0,r=0;
        for (int i = 0; i < arr.length - 2; i++) {
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (s.contains(curr_sum - arr[j])) {
                    p=arr[i];
                    q=arr[j];
                    r=curr_sum - arr[j];
                    System.out.print(""+ arr[i]+" "+arr[j]+" "+ (curr_sum - arr[j]));
                    //return true;
                }
                s.add(arr[j]);
            }
        }
        return p+q+r;
    }

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int arr_size = A.length;

        tripletSum(A, sum);
    }
}
