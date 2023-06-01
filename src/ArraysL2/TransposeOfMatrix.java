package ArraysL2;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        int inp[][]={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int res[][]=transpose(inp);
        for (int i = 0; i <res.length ; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] transpose(int[][] matrix){
    int n=matrix.length;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        return matrix;
    }
}
