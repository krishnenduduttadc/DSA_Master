package GraphL1;

public class NoOfIslands {
    public static void main(String[] args) throws Exception {
        int[][] arr = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0}
        };

        int m = arr.length; // Number of rows
        int n = arr[0].length; // Number of columns


        // write your code herec
        boolean[][] v = new boolean[arr.length][arr[0].length];
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0 && v[i][j] == false){
                    d(arr, i, j, v);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void d(int[][] arr, int i, int j, boolean[][] v){
        if(i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] == 1 || v[i][j] == true){
            return;
        }
        v[i][j] = true;
        d(arr, i - 1, j, v);
        d(arr, i , j + 1, v);
        d(arr, i, j - 1, v);
        d(arr, i + 1, j, v);

    }
}
