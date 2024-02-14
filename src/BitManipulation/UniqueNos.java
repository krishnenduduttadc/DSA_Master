/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BitManipulation;

/**
 *
 * @author krish
 */
public class UniqueNos {

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3, 3, 5, 5};
        System.out.println("" + unique(arr));
    }

    private static int unique(int[] arr) {
        int n = arr.length;
        int cumxor = 0;
        for (int i = 0; i < n; i++) {
            cumxor = cumxor ^ arr[i];
        }
        return cumxor;
    }
}
