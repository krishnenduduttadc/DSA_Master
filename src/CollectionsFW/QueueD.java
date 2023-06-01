package CollectionsFW;

import java.util.LinkedList;
import java.util.Queue;

public class QueueD {
    public static void main(String[] args) {
        Queue<String> q=new LinkedList<>();
        q.offer("amit");
        q.offer("sumit");
        q.offer("rohit");
        System.out.println(q);
        System.out.println(q.peek());
    }
}
