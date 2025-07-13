package StackL2;

import java.util.ArrayDeque;

public class DesignHitCounter {
    public static void main(String[] args) {
        HitCounter obj = new HitCounter();

        // Hardcoded input
        obj.hit(1);      // Hit at t=1
        obj.hit(2);      // Hit at t=2
        obj.hit(300);    // Hit at t=300

        System.out.println(obj.getHits(300));  // Expected: 3

        obj.hit(301);    // Hit at t=301
        System.out.println(obj.getHits(301));  // Expected: 3 (1 is out of range now)
    }

    static class HitCounter {
        ArrayDeque<Integer> q;

        /**
         * Initialize your data structure here.
         */
        public HitCounter() {
            q = new ArrayDeque<>();
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            q.add(timestamp);
            int start = timestamp - 300 + 1;
            while (!q.isEmpty() && q.peek() < start) {
                q.remove();
            }
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            int start = timestamp - 300 + 1;
            while (!q.isEmpty() && q.peek() < start) {
                q.remove();
            }

            return q.size();
        }
    }
}
