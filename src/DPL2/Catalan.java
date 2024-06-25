package DPL1;

public class Catalan {
    //c4=c0c3+c1c2+c2c1+c3c0;
    public static void main(String[] args) {
        int n=10;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }

        for (int i = 0; i <dp.length ; i++) {
            System.out.print(dp[i]+" ");
        }

    }
}
