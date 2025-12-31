package ArraysL1;

import java.util.Arrays;

public class BrokenEconomy {
    public static void main(String[] args) {
        int[] a = {4, 3, 6, 2, 1};
        int d = 2;

        Arrays.sort(a);

        int l = 0;
        int h = a.length - 1;
        int ceil = -1;
        int floor = -1;

        while (l <= h) {
            int m = (l + h) / 2;

            if (d < a[m]) {
                ceil = a[m];  // Possible ceil
                h = m - 1;
            } else if (d > a[m]) {
                floor = a[m];  // Possible floor
                l = m + 1;
            } else {
                ceil = floor = a[m];  // Exact match
                break;
            }
        }

        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }
}
