/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueue;

/**
 *
 * @author krish
 */
public class CheckMaxHeap {

    public static boolean checkMaxHeap(int arr[]) {
        /*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
         */
        for (int i = 0; i < arr.length; i++) {
            int pIndex = i;
            int lIndex = 2 * i + 1;
            int rIndex = 2 * i + 2;

            if (lIndex < arr.length && arr[pIndex] < arr[lIndex]) {
                return false;
            }

            if (rIndex < arr.length && arr[pIndex] < arr[rIndex]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {42, 20, 18, 6, 14 ,11, 9, 4};
        System.out.println(checkMaxHeap(arr));
    }
}
