package ArraysL3;

public class MaxSubmatrixSumofSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 10}
        };
        int n = arr.length;
        int m = arr[0].length;
        int[][] pf = prefix(arr);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = sumRegion(i, j, n - 1, m - 1, pf);
                ans = Math.max(ans, temp);
            }
        }
        System.out.println(ans);
    }

    public static int sumRegion(int row1, int col1, int row2, int col2, int[][] psum) {
        int ans = 0;

        ans = ans + psum[row2][col2];
        if (row1 > 0) {
            ans -= psum[row1 - 1][col2];
        }

        if (col1 > 0) {
            ans -= psum[row2][col1 - 1];
        }

        if (row1 > 0 && col1 > 0) {
            ans += psum[row1 - 1][col1 - 1];
        }

        return ans;
    }

    public static int[][] prefix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] psum = new int[arr.length][arr[0].length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    psum[i][j] = arr[i][j];
                } else {
                    psum[i][j] = psum[i][j - 1] + arr[i][j];
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                psum[i][j] = psum[i - 1][j] + psum[i][j];
            }
        }

        return psum;
    }

}
