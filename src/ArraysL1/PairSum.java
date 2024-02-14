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
public class PairSum {

    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        System.out.println("" + pairSum(arr,9));
    }

    public static int pairSum(int[] arr, int num) {
        //Your code goes here
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] + arr[j] == num) {
                    cnt++;
                }
            }

        }
        return cnt;
    }

}
