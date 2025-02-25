class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; ++i) {
            int revenue = future[i] - present[i];
            for (int b = budget; b >= 0; --b) {
                if (b - present[i] < 0 || revenue <= 0) continue;
                dp[b] = Math.max(revenue + dp[b - present[i]], dp[b]);
            }
        }

        return dp[budget];
    }
}