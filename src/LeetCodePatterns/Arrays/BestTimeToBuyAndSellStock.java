package LeetCodePatterns.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int x = maxProfit(prices);
        System.out.println(x);

    }

    static int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int ans = 0;

        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - minSoFar;
            if (profit > ans) {
                ans = profit;
            }
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return ans;
    }
}
