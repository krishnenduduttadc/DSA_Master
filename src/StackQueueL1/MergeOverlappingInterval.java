package StackQueueL1;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingInterval {

    public static void main(String[] args) throws Exception {
        int[][] arr = {
                {22, 28},
                {1, 8},
                {25, 27},
                {14, 19},
                {27, 30},
                {5, 12}
        };

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // Merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs); // sort by start time

        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                if (pairs[i].st > top.et) {
                    st.push(pairs[i]);
                } else {
                    top.et = Math.max(top.et, pairs[i].et);
                }
            }
        }

        // Reverse the stack to maintain increasing order
        Stack<Pair> rs = new Stack<>();
        while (!st.isEmpty()) {
            rs.push(st.pop());
        }

        while (!rs.isEmpty()) {
            Pair p = rs.pop();
            System.out.println(p.st + " " + p.et);
        }
    }

    static class Pair implements Comparable<Pair> {
        int st;
        int et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.et - other.et;
            }
        }
    }
}
