package DPL2;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str="abccba";
        int n=str.length();
        int[][] dp=new int[n][n];

        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    dp[i][j]=str.charAt(i)==str.charAt(j)?2:1;
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=2+dp[i+1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }

        System.out.println(dp[0][n-1]+" ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }
}
