package DP1;

public class PaintHouseManyColors {
    public static void main(String[] args) throws Exception {


        int [][] arr ={{1,5,7,2,3,4},{5,8,4,3,6,1},{3,2,9,7,2,3},{1,2,4,9,1,7}};
        int n = arr.length;
        int c = arr[0].length;



        int[][] dp = new int[arr.length][arr[0].length];

        for(int j = 0; j < arr[0].length; j++){
            dp[0][j] = arr[0][j];
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                int min = Integer.MAX_VALUE;

                for(int k = 0; k < dp[0].length; k++){
                    if(k != j){
                        if(dp[i - 1][k] < min){
                            min = dp[i - 1][k];
                        }
                    }
                }

                dp[i][j] = arr[i][j] + min;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int k = 0; k < dp[0].length; k++){
            if(dp[n - 1][k] < min){
                min = dp[n - 1][k];
            }
        }

        System.out.println(min);
    }
}
