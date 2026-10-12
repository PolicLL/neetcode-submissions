class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[prices.length - 1], profit = 0;

        for (int i = prices.length - 2; i >= 0; --i) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);   
        }

        return profit;
    }
}
