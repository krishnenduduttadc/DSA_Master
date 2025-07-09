package HML2;

import java.util.HashMap;

public class LineReflection {
    public static boolean isReflected(int[][] points) {
        HashMap<Long, Long> map = new HashMap<>();
        long xmin = Integer.MAX_VALUE;
        long xmax = Integer.MIN_VALUE;

        for (int[] point : points) {
            long x = point[0];
            long y = point[1];
            xmin = Math.min(xmin, x);
            xmax = Math.max(xmax, x);

            long hash = x * 100000000L + y;
            map.put(hash, 1L);
        }

        long mirr = xmin + xmax;

        for (int[] point : points) {
            long x = point[0];
            long y = point[1];

            long ximg = mirr - x;
            long hash = ximg * 100000000L + y;
            if (!map.containsKey(hash)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1, 1},
                {9, 1},
                {8, 2},
                {2, 2}
        };
        System.out.println(isReflected(points)); // true
    }
}
