package HML1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }

    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            // write your code here
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

        public int remove() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            // write your code here
            return left.size() + right.size();
        }
    }
}

/*
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit
 */
