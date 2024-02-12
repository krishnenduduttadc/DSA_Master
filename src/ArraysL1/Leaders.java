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
public class Leaders {

    static void leaders(int arr[]) {
        int n = arr.length;
        int curr = arr[n - 1];
        System.out.print(curr + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > curr) {
                curr = arr[i];
                System.out.print(curr + " ");
            }
        }
    }

    public static void main(String a[]) {
        leaders(new int[]{7,10,4,10,6,5,2});
    }
}
