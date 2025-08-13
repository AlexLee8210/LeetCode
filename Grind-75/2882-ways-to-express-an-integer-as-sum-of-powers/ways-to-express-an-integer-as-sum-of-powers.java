class Solution {
    public int numberOfWays(int n, int x) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                int add = (int) Math.pow(j, x);
                dp[i][j] = (dp[i][j - 1] + (i - add >= 0 ? dp[i - add][j - 1] : 0)) % MOD;
            }
        }

        return dp[n][n];
    }
}