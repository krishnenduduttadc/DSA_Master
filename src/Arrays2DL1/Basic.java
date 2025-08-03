package Arrays2DL1;

public class Basic {
    public static void main(String[] args) throws Exception {
        // Hardcoded input
        int n = 2;
        int m = 4;
        int[][] arr = {
                {11, 12, 13, 14},
                {21, 22, 23, 24}
        };

        // Printing the 2D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
