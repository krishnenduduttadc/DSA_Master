package LeetCodePatterns.Heaps;

import java.util.PriorityQueue;

public class LastStoneWeight {

    // Testing
    public static void main(String[] args) {
        LastStoneWeight solver = new LastStoneWeight();

        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Last stone weight: " + solver.lastStoneWeight(stones1));
        // Expected: 1
    }

    public int lastStoneWeight(int[] stones) {
        // Max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll(); // heaviest
            int x = pq.poll(); // 2nd heaviest
            if (x != y) {
                pq.offer(y - x);
            }
        }

        return pq.size() > 0 ? pq.poll() : 0;
    }
}
