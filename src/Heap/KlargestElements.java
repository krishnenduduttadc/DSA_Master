/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author krish
 */
public class KlargestElements {

    static void klargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                continue;
            } else {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        Iterator g_iterator = pq.iterator();
        System.out.print("3 greatest values : ");
        while (g_iterator.hasNext()) {
            System.out.print(g_iterator.next() + " ");
        }
    }

    public static void main(String[] args) {
        klargest(new int[]{5, 15, 10, 20, 8, 25, 18}, 3);
    }
}
