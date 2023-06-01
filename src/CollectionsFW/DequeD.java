package CollectionsFW;

import java.util.ArrayDeque;

public class DequeD {
    public static void main(String[] args) {
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        dq.offerFirst(1);
        dq.offerFirst(2);
        dq.offerLast(3);
        System.out.println(dq);
        System.out.println(dq.peekFirst());
    }
}
