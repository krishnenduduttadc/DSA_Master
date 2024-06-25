package DPL1;

public class LargestSquareSubmatrix {
    public static void main(String[] args) {
        int[][] arr = { {0,1,0,1,0,1},
                        {1,0,1,0,1,0},
                        {0,1,1,1,1,0},
                        {0,0,1,1,1,0},
                        {1,1,1,1,1,1}};
        int[][] dp=new int[arr.length][arr[0].length];
        int ans=0;

        for (int i = dp.length-1; i >=0 ; i--) {
            for (int j = dp[0].length-1; j >=0 ; j--) {
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=arr[i][j];
                }else if(i== dp.length-1){
                    dp[i][j]=arr[i][j];
                }else if(j==dp[0].length-1){
                    dp[i][j]=arr[i][j];
                }else{
                    if(arr[i][j]==0){
                        dp[i][j]=0;
                    }else{
                        int min=Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i+1][j+1]));
                        dp[i][j]=min+1;

                        if(dp[i][j]>ans){
                            ans=dp[i][j];
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
