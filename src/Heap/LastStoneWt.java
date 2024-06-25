package Heap;

import RecursionAndBacktrackingL1.Solution;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWt {
    public static void main(String[] args) {
        // Hardcoded input array of stones
        int[] stones = {2, 7, 4, 1, 8, 1};

        // Create an instance of the Solution class
        LastStoneWt solution = new LastStoneWt();

        // Call the lastStoneWeight method and store the result
        int result = solution.lastStoneWeight(stones);

        // Print the result
        System.out.println("The last stone weight is " + result);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            if (first != second) {
                pq.add(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.remove();
    }
}
