package LeetCodePatterns.ArrayInterval;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        // Example 1: Overlapping intervals
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Output: " + solution.canAttendMeetings(intervals1));
        // Expected: false
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
