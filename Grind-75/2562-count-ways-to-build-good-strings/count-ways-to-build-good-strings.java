class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;

        int res = 0;

        for (int i = 1; i < low; ++i) {
            if (i >= zero) {
                dp[i] = dp[i - zero];
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % 1000000007;
            }
        }

        for (int i = low; i <= high; ++i) {
            dp[i] = (dp[i - zero] + dp[i - one]) % 1000000007;
            res = (res + dp[i]) % 1000000007;
        }

        return res;
    }
}