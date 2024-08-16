class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '0') continue;

                dp[r][c] = 1;
                if (r != 0 && c != 0) {
                    dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                }
                maxLen = Math.max(maxLen, dp[r][c]);
            }
        }
        return maxLen * maxLen;
    }
}