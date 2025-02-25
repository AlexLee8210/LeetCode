class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[][] dp = new int[n + 1][budget + 1];

        for (int i = 0; i < n; ++i) {
            int revenue = future[i] - present[i];
            for (int b = 0; b <= budget; ++b) {
                if (b - present[i] < 0 || revenue <= 0) {
                    dp[i + 1][b] = dp[i][b];
                } else {
                    dp[i + 1][b] = revenue + dp[i][b - present[i]];
                    dp[i + 1][b] = Math.max(dp[i + 1][b], dp[i][b]);
                }
            }
        }

        return dp[n][budget];
    }
}