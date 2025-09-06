package CodeChef_java_coding_interview.PQ;

import java.util.Collections;
import java.util.PriorityQueue;

public class SmallestSubset {
    public static void main(String[] args) {
        int[] nums = {4, 8, 2, 12, 20, 30};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            sum += nums[i];
        }

        int r = 0;
        int s = 0;
        while (s < (sum - s)) {
            s += pq.poll();
            r++;
        }

        System.out.println(r);
    }
}
