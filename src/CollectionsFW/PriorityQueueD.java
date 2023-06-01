package CollectionsFW;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueD {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.offer(4);

        System.out.println(pq.peek());
    }
}
