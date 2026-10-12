class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[prices.length - 1];
        int profit = 0;

        for (int i = prices.length - 2; i >= 0; --i) {
            int temp = prices[i];
            max = Math.max(max, temp);
            profit = Math.max(profit, max - temp);   
        }

        return profit;
    }
}
