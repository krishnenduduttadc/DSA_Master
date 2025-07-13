package Arrays2DL1;

public class Spiral {
    public static void main(String[] args) throws Exception {
        int[][] arr = {
                {11, 12, 13, 14, 15},
                {21, 22, 23, 24, 25},
                {31, 32, 33, 34, 35}
        };

        int n = arr.length;
        int m = arr[0].length;

        int minr = 0;
        int minc = 0;
        int maxr = n - 1;
        int maxc = m - 1;
        int tne = n * m;
        int cnt = 0;

        while (cnt < tne) {
            for (int i = minr, j = minc; i <= maxr && cnt < tne; i++) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            minc++;

            for (int i = maxr, j = minc; j <= maxc && cnt < tne; j++) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxr--;

            for (int i = maxr, j = maxc; i >= minr && cnt < tne; i--) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            maxc--;

            for (int i = minr, j = maxc; j >= minc && cnt < tne; j--) {
                System.out.println(arr[i][j]);
                cnt++;
            }
            minr++;
        }
    }
}
