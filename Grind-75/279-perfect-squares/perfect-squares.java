class Solution {
    public int numSquares(int n) {
        if (n <= 3) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}