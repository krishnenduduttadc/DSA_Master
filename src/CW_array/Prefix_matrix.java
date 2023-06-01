package CW_array;

public class Prefix_matrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}};
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int sum=findSum(matrix,0,0,3,3);
        System.out.println(sum);
    }

    static int findSum(int[][] matrix, int l1, int r1, int l2, int r2) {
        int sum = 0;
        prefixsum(matrix);
        for (int i = l1; i <= l2; i++) {
            //r1 to r2 sum for i
            if (r1 >= 1)
                sum += matrix[i][r2] - matrix[i][r1 - 1];
            else
                sum += matrix[i][r2];
        }
        return sum;
    }

    private static void prefixsum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        System.out.println("pfsum");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
