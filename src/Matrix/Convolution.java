package Matrix;

public class Convolution {
    public static void main(String[] args) {
        int[][] paddedMat = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 2, 3, 4, 5},
                {0, 4, 5, 6, 9, 1},
                {0, 7, 8, 6, 6, 5},
                {0, 7, 2, 9, 6, 1},
                {0, 7, 8, 3, 6, 5},
                {0, 0, 0, 0, 0, 0}
        };

        int[][] kernel = {
                {1, 1},
                {1, 1}
        };

        int kernelSize = 2;
        int paddedRows = paddedMat.length;
        int paddedCols = paddedMat[0].length;

        int resultRows = paddedRows - kernelSize + 1;
        int resultCols = paddedCols - kernelSize + 1;

        int[][] result = new int[resultRows][resultCols];

        for (int i = 0; i < resultRows; i++) {
            for (int j = 0; j < resultCols; j++) {
                int sum = 0;
                for (int k = 0; k < kernelSize; k++) {
                    for (int l = 0; l < kernelSize; l++) {
                        sum += paddedMat[i + k][j + l] * kernel[k][l];
                    }
                }
                result[i][j] = sum;
            }
        }


        // Print result
        for (int i = 0; i < resultRows; i++) {
            for (int j = 0; j < resultCols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
