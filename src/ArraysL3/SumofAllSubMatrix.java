package ArraysL3;

public class SumofAllSubMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = arr.length;
        int m = arr[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int occ = (i + 1) * (j + 1) * (n - i) * (m - j);

                ans = ans + (occ * arr[i][j]);
            }
        }
        System.out.println(ans);
    }

}
