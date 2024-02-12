/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

import java.util.Arrays;

/**
 *
 * @author krish
 */
public class RecursiveBubble {
    static void bubbleSort(int arr[], int n) 
    { 
        if(n==1)return;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        bubbleSort(arr, n-1);
    }
    public static void main(String a[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};       
        bubbleSort(arr, arr.length);          
        System.out.println("Sorted array : "); 
        System.out.println(Arrays.toString(arr)); 
    }
}
