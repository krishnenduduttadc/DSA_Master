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
public class SumofArr {
    static int arr[] = { 1, 2, 3, 4, 5,-66 }; 
    static int findSum(int A[], int N) 
    { 
        if(N<=0)return 0;
        return findSum(A, N-1)+A[N-1];
    }
    public static void main(String a[]) {
        System.out.println(findSum(arr, arr.length)); 
    }
}
