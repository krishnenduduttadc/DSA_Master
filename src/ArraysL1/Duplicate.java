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
public class Duplicate {

    public static void main(String[] args) {
        int arr[] = {0, 7, 2, 5, 4, 7, 1, 3, 6};
        System.out.println("" + findDuplicate1(arr));
    }

    public static int findDuplicate(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    res = arr[i];
                }
            }
        }
        return res;
    }

    public static int findDuplicate1(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
            } else {
                res = j;
            }
        }
        return res;
    }

}
