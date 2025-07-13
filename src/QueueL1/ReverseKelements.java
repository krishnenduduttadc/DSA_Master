package QueueL1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKelements {
    public static void main(String[] args) {
        // Create a queue and add some elements
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // Define the value of k
        int k = 3;

        // Call the modifyQueue method and store the result
        Queue<Integer> result = modifyQueue(q, k);

        // Print the result queue
        System.out.println(result);
    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();

        for (int i = 1; i <= k; i++) {
            st.push(q.remove());
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        for (int i = 1; i <= q.size() - k; i++) {
            q.add(q.remove());
        }

        return q;
    }
}
