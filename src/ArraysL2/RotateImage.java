package ArraysL2;

public class RotateImage {
    public static void main(String[] args) {
        int inp[][]={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        //transpose
        int res[][]=transpose(inp);
        for (int i = 0; i <res.length ; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        //roate
        reverseRow(res);

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

    static void reverseRow(int[][] arr){
        for (int r = 0; r < arr.length; r++) {
            int left=0;
            int right=arr.length-1;

            while(left<right){
                int tmp=arr[r][left];
                arr[r][left]=arr[r][right];
                arr[r][right]=tmp;
                left++;
                right--;
            }
        }
    }
}
