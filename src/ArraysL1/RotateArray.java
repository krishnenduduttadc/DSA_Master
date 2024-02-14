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
public class RotateArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        rotate(arr,5);
    }

    private static void rotate(int[] arr, int d) {
        
        int n=arr.length;
        int temp[]=new int[d];
        for (int i = 0; i < d; i++) {
            temp[i]=arr[i];
        }
               
        for (int i = d; i < n; i++) {
            arr[i-d]=arr[i];
        }
        
        for (int i = 0; i < d; i++) {
            arr[n-d+i]=temp[i];
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(" "+arr[i]);
        }
    }
    
}
