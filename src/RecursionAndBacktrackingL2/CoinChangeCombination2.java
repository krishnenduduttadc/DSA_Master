package RecursionAndBacktrackingL2;

public class CoinChangeCombination2 {
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        // write your code here

        if(i==coins.length){
            if(amtsf==tamt){
                System.out.println(asf+".");
            }
            return;
        }


        for(int j=tamt/coins[i];j>=1;j--){
            String part="";
            for(int k=0;k<j;k++){
                part=part+coins[i]+"-";
            }
            coinChange(i+1,coins,amtsf+coins[i]*j,tamt,asf+part);
        }
        coinChange(i+1,coins,amtsf,tamt,asf);
    }

    public static void main(String[] args) throws Exception {
        int[] coins = {2,3,5,6,7};
        int amt = 12;
        coinChange(0, coins, 0, amt, "");
    }
}

/*

5
2
3
5
6
7
12
 */
