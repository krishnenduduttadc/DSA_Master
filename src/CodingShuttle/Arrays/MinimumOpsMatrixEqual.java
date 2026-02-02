package CodingShuttle.Arrays;

import java.util.Arrays;

public class MinimumOpsMatrixEqual {
    public static void main(String[] args) {

//        int a[][] = {{3, 63, 42},
//                    {18, 12, 12},
//                    {15, 21, 18},
//                    {33, 84, 24}};
        int[][] a = {{4, 4, 10, 12, 18, 110, 1000}};
        int k = 2;
        System.out.println(makeMatrixEqual(a, k));

    }

    static int makeMatrixEqual(int[][] a, int k) {
        int n = a.length;
        if (n == 0) return 0;
        int m = a[0].length;
        int total = n * m;
        int[] b = new int[total];

        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, b, i * m, m);
        }

        Arrays.sort(b);

        int median = b[total / 2];


        for (int i = 0; i < total; i++) {
            System.out.println(i + " " + b[i] + " " + makeMatrixEqualHelper(b, b[i], k));
        }

        return makeMatrixEqualHelper(b, median, k);

    }

    static int makeMatrixEqualHelper(int[] b, int m, int k) {
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            count += Math.abs(b[i] - m) / k;
        }
        return count;
    }
}
