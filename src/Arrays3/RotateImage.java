package Arrays3;


public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int[] temp = matrix[i];

            int sp = 0;
            int ep = temp.length - 1;

            while (sp < ep) {
                int t = temp[sp];
                temp[sp] = temp[ep];
                temp[ep] = t;
                sp++;
                ep--;
            }

            matrix[i] = temp;
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        print2DArray(matrix);

        solution.rotate(matrix);

        System.out.println("Rotated matrix:");
        print2DArray(matrix);
    }

    // Method to print the 2D array
    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
