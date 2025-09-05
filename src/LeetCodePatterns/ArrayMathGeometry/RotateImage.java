package LeetCodePatterns.ArrayMathGeometry;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        // Expected: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int row = 0; row < n; row++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }


    }
}
