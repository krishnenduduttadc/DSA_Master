package MatrixL1;

public class Padding {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 4, 5},
                {4, 5, 6, 9, 1},
                {7, 8, 6, 6, 5},
                {7, 2, 9, 6, 1},
                {7, 8, 3, 6, 5}
        };
        solve2(mat);
    }

    static void solve(int[][] mat) {

        int n = mat.length;
        int[][] row = new int[1][n + 2];

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < row[0].length; j++) {
                row[i][j] = 0;
            }
        }

        int[][] res = new int[n + 2][n + 2];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (i == 0) {
                    res[i][j] = row[0][j];
                } else if (i == res.length - 1) {
                    res[i][j] = row[0][j];
                } else if (j == 0) {
                    res[i][j] = row[0][j];
                } else if (j == res[0].length - 1) {
                    res[i][j] = row[0][j];
                }
            }
        }

        for (int i = 1; i < res.length - 1; i++) {
            for (int j = 1; j < res[0].length - 1; j++) {
                res[i][j] = mat[i - 1][j - 1];
            }
            System.out.println();
        }


        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solve2(int[][] mat){
        int paddedRows = mat.length + 2; // Adding 2 rows for top and bottom padding
        int paddedCols = mat[0].length + 2; // Adding 2 columns for left and right padding

        int[][] paddedMat = new int[paddedRows][paddedCols];

        // Fill padded matrix with zeros
        for (int i = 0; i < paddedRows; i++) {
            for (int j = 0; j < paddedCols; j++) {
                paddedMat[i][j] = 0;
            }
        }

        // Copy original matrix into padded matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                paddedMat[i + 1][j + 1] = mat[i][j]; // Offset by 1 to leave space for padding
            }
        }

        // Print padded matrix
        for (int i = 0; i < paddedRows; i++) {
            for (int j = 0; j < paddedCols; j++) {
                System.out.print(paddedMat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
