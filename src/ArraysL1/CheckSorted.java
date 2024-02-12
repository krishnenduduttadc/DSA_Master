/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysL1;

/**
 *
 * @author krish
 */
public class CheckSorted {

    public static void main(String a[]) {
        System.out.println(isSorted(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(isSortedEff(new int[]{11, 2, 3, 4, 5, 6}));
    }

    private static boolean isSortedEff(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
