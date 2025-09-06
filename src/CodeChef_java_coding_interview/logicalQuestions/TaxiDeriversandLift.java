package CodeChef_java_coding_interview.logicalQuestions;

import java.util.ArrayList;
import java.util.List;

public class TaxiDeriversandLift {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int n = 5;
        int m = 3;
        int[] x = {2, 3, 4, 5, 6, 7, 8, 9};
        int[] y = {1, 0, 0, 0, 1, 0, 0, 1};
        boolean[] driver_flag = new boolean[n + m];
        for (int i = 0; i < n + m; i++) {
            driver_flag[i] = (y[i] == 1);
        }

        List<Long> riders = new ArrayList<>();
        List<Long> drivers = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            if (driver_flag[i]) {
                drivers.add((long) x[i]);
            } else {
                riders.add((long) x[i]);
            }
        }

        drivers.add(Long.MAX_VALUE);
        int[] ans = new int[m];
        int rider = 0;
        for (int driver = 0; driver < m && rider < n; driver++) {
            long r = drivers.get(driver);
            long r2 = drivers.get(driver + 1);
            while (rider < n) {
                long p = riders.get(rider);
                long distance_first = Math.abs(p - r);
                long distance_second = Math.abs(p - r2);
                if (distance_first <= distance_second) {
                    ans[driver]++;
                } else {
                    break;
                }
                rider++;
            }
        }

        for (int v : ans) {
            System.out.println(v + " ");
        }
    }
}
