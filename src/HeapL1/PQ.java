/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeapL1;

import java.util.PriorityQueue;

/**
 *
 * @author krish
 */
public class PQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        p.add(10);
        p.add(20);
        p.add(15);

        System.out.println(p.peek());
        System.out.println(p.poll());
        System.out.println(p.peek());
        System.out.println(p.peek());
        System.out.println(p.peek());
    }
}
