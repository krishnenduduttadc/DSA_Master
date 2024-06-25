package DPL0;

public class CoinChangePermutation {
    public static void main(String[] args) {
        int coins[] = {2, 3, 5, 6};
        int tar = 10;
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int amt = 1; amt <dp.length ; amt++) {
            for (int coin:coins) {
                if(coin<=amt){
                    int ramt=amt-coin;
                    dp[amt]+=dp[ramt];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}
