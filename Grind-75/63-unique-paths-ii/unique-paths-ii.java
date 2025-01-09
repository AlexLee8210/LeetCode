class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (obstacleGrid[r][c] == 1) continue;
                if (r == 0 && c == 0) continue;
                if (r == 0) dp[r][c] = dp[r][c - 1];
                else if (c == 0) dp[r][c] = dp[r - 1][c];
                else dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}