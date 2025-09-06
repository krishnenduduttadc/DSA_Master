package CodeChef_java_coding_interview.PQ;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumCosttoConnectSticks {
    public static void main(String[] args) {
        int[] nums = {1, 8, 3, 5};
        ArrayList<Integer> sticks = new ArrayList<>();
        for (int num : nums) {
            sticks.add(num);
        }
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(sticks);
        int cost = 0;
        while (pq.size() >= 2) {
            cost = pq.poll() + pq.poll();
            result += cost;
            pq.add(cost);
            System.out.println(cost + " " + result);
        }

        System.out.println(result);
    }
}
