class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int cnt = 0;

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                dp[r][c] = matrix[r][c];
                if (matrix[r][c] == 0) continue;
                if (r == 0 || c == 0) {
                    ++cnt;
                    continue;
                }

                dp[r][c] += Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                cnt += dp[r][c];
            }
        }
        return cnt;
    }
}