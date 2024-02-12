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
public class ReverseArray {
    
    public static void main(String a[]) {
        reverse(new int[]{1, 2, 3, 4, 5, 6});
    }

    private static void reverse(int[] arr) {
       int low=0;int high=arr.length-1;
       while(low<high){
           int temp=arr[high];
           arr[high]=arr[low];
           arr[low]=temp;
           low++;
           high--;
       }
       
        for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i]+" ");
         }
    }
}
