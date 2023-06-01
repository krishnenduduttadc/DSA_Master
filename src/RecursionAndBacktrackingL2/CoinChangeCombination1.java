package RecursionAndBacktrackingL2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinChangeCombination1 {
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        // write your code here
        if(i==coins.length){
            if(amtsf==tamt){
                System.out.println(asf+".");
            }
            return;
        }
        coinChange(i+1,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");
        coinChange(i+1,coins,amtsf+0,tamt,asf);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());

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
