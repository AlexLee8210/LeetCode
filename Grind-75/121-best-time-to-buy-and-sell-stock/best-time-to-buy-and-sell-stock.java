class Solution {
    public int maxProfit(int[] prices) {
        int[] max = new int[prices.length];
        int[] min = new int[prices.length];
        max[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0 ; i--) {
            max[i] = Math.max(max[i + 1], prices[i]);
        }
        min[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, max[i] - min[i]);
        }
        return ans;
    }
}