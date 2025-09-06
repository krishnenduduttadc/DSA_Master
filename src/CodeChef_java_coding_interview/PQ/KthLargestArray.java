package CodeChef_java_coding_interview.PQ;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class KthLargestArray {
    public static void main(String[] args) {
        String nums[] = {"3", "6", "7", "10"};
        int k = 1;
        int n = nums.length;
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new BigInteger(nums[i]));
        }
        BigInteger num = null;
        int limit = n - k + 1;

        int i = 0;
        while (i < limit) {
            num = pq.poll();
            i++;
        }
        System.out.println(num.toString());
    }
}
