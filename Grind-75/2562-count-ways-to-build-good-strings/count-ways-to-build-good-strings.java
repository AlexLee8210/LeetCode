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

    // public int countGoodStrings(int low, int high, int zero, int one) {
    //     int res = 0;
    //     int[] memo = new int[high + 1];

    //     for (int i = low; i <= high; ++i) {
    //         res = (res + count(i, zero, one, memo)) % 1000000007;
    //     }

    //     return res;
    // }

    // private int count(int n, int zero, int one, int[] memo) {
    //     if (n == 0) return 1;

    //     if (memo[n] != 0) return memo[n];

    //     int zeroCount = zero <= n ? count(n - zero, zero, one, memo) : 0;
    //     int oneCount = one <= n ? count(n - one, zero, one, memo) : 0;

    //     memo[n] = (zeroCount + oneCount) % 1000000007;
    //     return memo[n];
    // }
}