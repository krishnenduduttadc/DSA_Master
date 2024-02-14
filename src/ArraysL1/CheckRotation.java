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
public class CheckRotation {

    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 2, 3, 4};
        int p = arrayRotateCheck(arr);
        System.out.println("" + p);
    }

    public static int arrayRotateCheck(int[] arr) {
        //Your code goes here
        int cnt = 0;
        int n = arr.length;

        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                cnt=i;
            }
        }
        return cnt;
    }

}
