class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] ans = new int[]{-1, -1};
        int maxLen = -1;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            dp[i][i] = true;
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) != s.charAt(j)) continue;
                if (j - i + 1 > 2) dp[i][j] = dp[i + 1][j - 1];
                else dp[i][j] = true;
                if (dp[i][j]) {
                    if (maxLen < j - i + 1) {
                        ans[0] = i;
                        ans[1] = j;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return maxLen == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}