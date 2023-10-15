package StackL2;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverageDataStream {
    public static class MovingAverage {

        private Queue<Integer> q;
        private final int size;
        private int sum;


        public MovingAverage(int size) {
            this.size = size;
            q = new ArrayDeque<>();
        }

        public double next(int val) {
            sum += val;
            q.add(val);

            if (q.size() > size) {
                sum -= q.remove();
            }
            double avg = ((double) sum) / q.size();
            return avg;
        }
    }

    public static void main(String[] args) throws Exception {

        int size = 2;
        MovingAverage obj = new MovingAverage(size);

        int val[] = {1, 10, 3, 5};
        for (int i = 0; i < val.length; i++) {
            double avg = obj.next(val[i]);
            StringBuilder ans = new StringBuilder(String.format("%.5f", avg));
            while (ans.charAt(ans.length() - 2) != '.' && ans.charAt(ans.length() - 1) == '0') {
                ans.deleteCharAt(ans.length() - 1);
            }
            System.out.println(ans);
        }


    }
}
