package MatrixL1;

public class MatrixSum {
    public static void main(String[] args) {
        int[][] mat = {
                {3, 8, 2, 1, 6},
                {1, 2, 1, 0, 3},
                {2, 6, 1, 1, 8},
                {2, 5, 6, 7, 8},
                {8, 6, 6, 5, 1}
        };
        int n=mat.length;
        int[][] salt={{1,1,1,1,1}};
        int[][] res=new int[n][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[i][j]=mat[i][j]+salt[0][i];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(res[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
