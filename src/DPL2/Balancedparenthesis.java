package DPL2;

public class Balancedparenthesis {
    public static void main(String[] args) {
        int n=5;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            int inside=i-1;
            int outside=0;
            while(inside>=0){
                dp[i]=dp[i]+dp[inside]*dp[outside];
                inside--;
                outside++;
            }
        }

        for (int i = 0; i <dp.length ; i++) {
            System.out.print(dp[i]+" ");
        }
//        char c='b';
//        System.out.println(c-'0');
    }
}
