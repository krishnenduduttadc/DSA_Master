package SearchandSortL2;

public class SerchIn2DMatrix {
    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int r = b1(matrix, target);
        if(r == -1){
            return false;
        }

        boolean i = b(matrix, r, target);

        return i;
    }

    public static boolean b(int[][]matrix, int r, int target){
        int lo = 0;
        int hi = matrix.length - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(matrix[r][mid] == target){
                return true;
            }
            else if(matrix[r][mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }

    public static int b1(int[][] matrix, int target){
        int lo = 0;
        int hi = matrix.length - 1;
        int lc = matrix[0].length - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(matrix[mid][0] <= target && target <= matrix[mid][lc]){
                return mid;
            }

            else if(matrix[mid][0] < target) {
                lo = mid + 1;
            } else if(matrix[mid][0] > target) {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[]args) {

        int m = 4;
        int n = 4;

        int[][]matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int target = 13;

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}
