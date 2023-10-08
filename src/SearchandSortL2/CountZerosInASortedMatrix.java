package SearchandSortL2;

public class CountZerosInASortedMatrix {
    public static int countZeros(int[][]mat) {
        int n = mat.length;
        int i = 0;
        int j = n - 1;

        int cz = 0;

        while(i < n && j >= 0){
            if(mat[i][j] == 1){
                j--;
            }
            else {
                cz = cz + j + 1;
                i++;
            }
        }

        return cz;
    }

    public static void main(String[]args) {
        //input work

        int n = 5;

        int[][]mat = {
                {0,0,0,1,1},
                {0,0,0,1,1},
                {0,0,1,1,1},
                {0,1,1,1,1},
                {0,1,1,1,1}};



        System.out.println(countZeros(mat));
    }
}
