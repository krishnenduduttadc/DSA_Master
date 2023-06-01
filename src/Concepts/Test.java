package Concepts;

public class Test {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int r = arr.length;
        int c = arr[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i < 0 || i >= r || j < 0 || j >= c) {
                    return;
                } else {
                    if (arr[i][j] == 1) {
                        if (i - 1 >= 0 && i - 1 < r) {
                            arr[i - 1][j] = 1;
                        }
                        if (i + 1 >= 0 && i + 1 < r) {
                            arr[i + 1][j] = 1;
                        }
                        if (j - 1 >= 0 && j - 1 < c) {
                            arr[i][j - 1] = 1;
                        }
                        if (j + 1 >= 0 && j + 1 < c) {
                            arr[i][j + 1] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
