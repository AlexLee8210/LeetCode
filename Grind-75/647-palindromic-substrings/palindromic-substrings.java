class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            dp[i][i] = true;
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) != s.charAt(j)) continue;
                if (j - i + 1 > 2) dp[i][j] = dp[i + 1][j - 1];
                else dp[i][j] = true;
                if (dp[i][j]) {
                    ++count;
                }
            }
        }

        return count;
    }
}