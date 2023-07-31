package DP1;

public class BestTimetoBuyandSellStocksInfiniteTransactions {
    public static void main(String[] args) throws Exception {
        // write your code here

        int n =9;

        int[] arr = {11,6,7,19,4,1,6,18,4};

        int bd = 0;
        int sd = 0;
        int profit = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= arr[i - 1]){
                sd++;
            } else {
                profit = profit + arr[sd] - arr[bd];
                bd = sd = i;
            }
        }

        profit = profit + arr[sd] - arr[bd];

        System.out.println(profit);
    }
}
