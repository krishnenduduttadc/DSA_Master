package DynamicProgramming2;

public class BestTimetoBuyandSellStocksOneTransactionAllowed {
    public static void main(String[] args) {
        int n = 9;
        int[] prices = {11,6,7,19,4,1,6,18,4};

        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i]<lsf){
                lsf=prices[i];
            }
            pist=prices[i]-lsf;

            if(pist>op){
                op=pist;
            }
        }
        System.out.println(op);
    }
}
