package LeetCodePatterns.Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    // Testing
    public static void main(String[] args) {
        MeetingRooms2 solver = new MeetingRooms2();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Minimum rooms required: " + solver.minMeetingRooms(intervals1));
        // Expected: 2

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Minimum rooms required: " + solver.minMeetingRooms(intervals2));
        // Expected: 1

        int[][] intervals3 = {{1, 5}, {2, 6}, {3, 7}, {4, 8}};
        System.out.println("Minimum rooms required: " + solver.minMeetingRooms(intervals3));
        // Expected: 4
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap to store earliest end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the end time of the first meeting
        minHeap.offer(intervals[0][1]);

        // Process remaining meetings
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // If the room is free, remove the earliest ending meeting
            if (currentStart >= minHeap.peek()) {
                minHeap.poll();
            }

            // Allocate a room (or reuse)
            minHeap.offer(currentEnd);
        }

        // Heap size = number of rooms needed
        return minHeap.size();
    }
}
