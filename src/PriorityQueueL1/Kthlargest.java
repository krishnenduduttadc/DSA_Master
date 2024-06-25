/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueueL1;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author krish
 */
public class Kthlargest {

    public static int kthLargest(int n, int[] input, int k) {
        // Write your code here
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }
        for (int j = 0; j < k - 1; j++) {
            pq.remove();
        }
        return pq.remove();

    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 9, 6, 8};
        int k = 3;
        System.out.print(kthLargest(arr.length,arr, k));

    }
}
