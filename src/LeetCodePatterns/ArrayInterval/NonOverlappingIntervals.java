package LeetCodePatterns.ArrayInterval;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        NonOverlappingIntervals solver = new NonOverlappingIntervals();

        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        int[][] intervals3 = {{1, 2}, {2, 3}};

        System.out.println("Result 1: " + solver.eraseOverlapIntervals(intervals1)); // Expected: 1
        System.out.println("Result 2: " + solver.eraseOverlapIntervals(intervals2)); // Expected: 2
        System.out.println("Result 3: " + solver.eraseOverlapIntervals(intervals3)); // Expected: 0
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
