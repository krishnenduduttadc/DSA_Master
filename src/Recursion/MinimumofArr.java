/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author krish
 */
public class MinimumofArr {
    static int getMin(int arr[], int i,int n) 
    {
        if(n==1){
            return arr[i];
        }
        else{
            return Math.min(arr[i],getMin(arr, i+1, n-1));
        }
    }
    
    static int getMax(int arr[],int i,int n){
        if(n==1){
            return arr[i];
        }else{
            return Math.max(arr[i],getMax(arr, i+1, n-1));
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 8, 45, 67, 9};
        int n = arr.length;
        System.out.println("Minimum element"
                + " of array: " + getMin(arr,0, n));
        System.out.println("Maximum element"+ " of array: " + getMax(arr,0, n));
    }
}
