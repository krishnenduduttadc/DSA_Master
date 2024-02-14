/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueue;

import java.util.PriorityQueue;

/**
 *
 * @author krish
 */
public class KlargestElements {

    public static void klargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            int min = pq.element();
            if (min < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 9, 6, 8};
        int k = 3;
        klargest(arr, k);
        
        
    }
}
