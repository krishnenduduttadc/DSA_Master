package Arrays2DL1;

public class Wakanda2 {
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = 4;
        int[][] arr = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44}
        };


        for (int g = 0; g < arr.length; g++) {
            for (int i = 0, j = g; j < arr.length; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}


