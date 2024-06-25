package MatrixL1;

import java.util.ArrayList;
import java.util.List;

public class MatrixBoundary {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {4, 5, 6, 9, 1},
                {7, 8, 6, 6, 5},
                {7, 2, 9, 6, 1},
                {7, 8, 3, 6, 5}
        };

        List<Integer> boundary = extractBoundary(mat);

        // Print boundary
        for (int num : boundary) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> extractBoundary(int[][] mat) {
        List<Integer> boundary = new ArrayList<>();

        int rows = mat.length;
        int cols = mat[0].length;

        // Top row
        for (int j = 0; j < cols; j++) {
            boundary.add(mat[0][j]);
        }

        // Right column (excluding the top-right and bottom-right corner)
        for (int i = 1; i < rows - 1; i++) {
            boundary.add(mat[i][cols - 1]);
        }

        // Bottom row (in reverse order)
        for (int j = cols - 1; j >= 0; j--) {
            boundary.add(mat[rows - 1][j]);
        }

        // Left column (excluding the top-left and bottom-left corner, in reverse order)
        for (int i = rows - 2; i > 0; i--) {
            boundary.add(mat[i][0]);
        }

        return boundary;
    }
}
