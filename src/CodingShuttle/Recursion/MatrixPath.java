package CodingShuttle.Recursion;

public class MatrixPath {
    public static void main(String[] args) {
        System.out.println(matrixPaths(2, 2));
    }

    static int matrixPaths(int n, int m) {
        if (n == 1 || m == 1) return 1;
        return matrixPaths(n - 1, m) + matrixPaths(n, m - 1);
    }
}
