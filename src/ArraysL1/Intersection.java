/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.*;

/**
 *
 * @author krish
 */
public class Intersection {

    public static void main(String[] args) {
        int arr1[] = {2, 6, 8, 5, 4, 3};
        int arr2[] = {2, 3, 4, 7};
        intersection(arr1, arr2);
    }

    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here

//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr2.length; j++) {
//                if (arr1[i] == arr2[j]) {
//                    System.out.print(" " + arr1[i]);
//                }
//            }
//        }
        int n = arr1.length;
        int m = arr2.length;
        Set<Integer> s1 = new LinkedHashSet<Integer>();
        Set<Integer> s2 = new LinkedHashSet<Integer>();

        for (int i = 0; i < n; i++) {
            s1.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            s2.add(arr2[i]);
        }
        s1.retainAll(s2);
        Integer[] intersection=s1.toArray(new Integer[s1.size()]);
        
        for (int i = 0; i < intersection.length; i++) {
            System.out.print(" "+intersection[i]);
        }

    }

}
