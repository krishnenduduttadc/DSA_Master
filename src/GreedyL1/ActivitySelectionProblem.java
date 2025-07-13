/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreedyL1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author krish
 */
class Activity {
    int start;
    int finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class MyCmp implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return a1.finish - a2.finish;
    }
}

public class ActivitySelectionProblem {

    static int maxActivity(Activity[] arr) {
        Arrays.sort(arr, new MyCmp());
        int res = 1;
        int prev = 0;
        for (int curr = 1; curr < arr.length; curr++) {
            if (arr[curr].start >= arr[prev].finish) {
                res++;
                prev = curr;
            }
        }
        return res;
    }

    public static void main(String a[]) {
        Activity[] arr = {new Activity(12, 25), new Activity(10, 20), new Activity(20, 30)};
        System.out.print(maxActivity(arr));
    }
}
