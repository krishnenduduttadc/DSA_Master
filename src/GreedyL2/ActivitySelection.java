package GreedyL2;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        int n = start.length;

        // Sorting activities by end time
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

        // Greedy selection
        int count = 1; // Pick first
        int lastEnd = activities[0][1];
        System.out.print("Selected activities: [(" + activities[0][0] + "," + activities[0][1] + ")] ");

        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastEnd) {
                count++;
                lastEnd = activities[i][1];
                System.out.print("[(" + activities[i][0] + "," + activities[i][1] + ")] ");
            }
        }

        System.out.println("\nMax Activities = " + count);
    }
}

