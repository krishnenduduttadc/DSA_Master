package Concepts;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(3);
        pq.add(1);

        System.out.println(pq);
        System.out.println(pq.peek());

        PriorityQueue<Integer> pqm=new PriorityQueue<>(Collections.reverseOrder());
        pqm.add(5);
        pqm.add(2);
        pqm.add(3);
        pqm.add(1);

        System.out.println(pqm);
        System.out.println(pqm.peek());
    }
}
