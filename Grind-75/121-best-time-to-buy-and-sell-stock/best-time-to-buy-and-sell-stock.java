class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minCost = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            minCost = Math.min(prices[i], minCost);
            max = Math.max(prices[i] - minCost, max);
        }
        return max;
    }
}