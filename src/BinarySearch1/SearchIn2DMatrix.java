package BinarySearch1;


public class SearchIn2DMatrix {

        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            int lo = 0, hi = n*m-1;
            while(lo<=hi){
                int mid = (lo+hi)/2;
                int r = mid/m;
                int c = mid%m;
                if(matrix[r][c] == target) return true;
                else if(matrix[r][c] < target) lo = mid+1;
                else hi = mid-1;

            }
            return false;
        }

    public static void main(String[] args) {
        SearchIn2DMatrix solution = new SearchIn2DMatrix();

        // Example test cases
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Matrix 1 contains target 3: " + solution.searchMatrix(matrix1, target1)); // Output: true
    }

    }
