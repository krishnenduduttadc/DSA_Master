package GreedyL2;

import java.util.Arrays;

//Find the minimum number of platforms required for trains.
public class MinPlatforms {
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] depart = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arrival.length;

        Arrays.sort(arrival);
        Arrays.sort(depart);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= depart[j]) {
                plat_needed++;
                i++;
            } else {
                plat_needed--;
                j++;
            }
            result = Math.max(result, plat_needed);
        }

        System.out.println("Minimum platforms required = " + result);
    }
}

