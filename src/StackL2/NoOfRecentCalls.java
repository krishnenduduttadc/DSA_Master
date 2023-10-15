package StackL2;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfRecentCalls {
    public static class RecentCounter {
        private Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.add(t);
            int min = t - 3000;
            while (q.peek() < min) {
                q.remove();
            }

            return q.size();
        }
    }

    public static void main(String[] args) throws Exception {

        RecentCounter obj = new RecentCounter();

        int val[] = {1, 100, 3001, 3002};
        for (int i = 0; i < val.length; i++) {
            int ans = obj.ping(val[i]);
            System.out.println(ans);
        }

    }
}
