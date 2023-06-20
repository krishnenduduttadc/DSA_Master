package DP2;

public class LongestCommonSubseq {
    public static void main(String[] args) {
        String s1="abc";
        String s2="bac";

        int[][] dp=new int[s1.length()+1][s2.length()+1];

        for(int i=dp.length-2;i>=0;i--){
            for (int j = dp[0].length-2; j >=0 ; j--) {
                char c1=s1.charAt(i);
                char c2=s1.charAt(j);

                if(c1==c2){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        System.out.println(dp[0][0]);

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
