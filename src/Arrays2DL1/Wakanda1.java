package Arrays2DL1;

public class Wakanda1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        int[][] arr = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34}
        };

        int n = arr.length;      // 3 rows
        int m = arr[0].length;   // 4 columns


        for (int j = 0; j < m; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.println(arr[i][j]);
                }

            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}


