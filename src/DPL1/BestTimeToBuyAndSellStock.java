package DPL1;

public class BestTimeToBuyAndSellStock {
        public int maxProfit(int[] prices) {
            int maxP = 0;
            int minBP = prices[0];
            for(int prc : prices){
                int tp = prc - minBP;
                if(tp > maxP){
                    maxP = tp;
                }
                minBP = Math.min(minBP , prc);
            }
            return maxP;
        }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int maxProfit1 = solution.maxProfit(prices1);
        System.out.println("Max profit for prices1: " + maxProfit1); // Output: 5
    }

    }
