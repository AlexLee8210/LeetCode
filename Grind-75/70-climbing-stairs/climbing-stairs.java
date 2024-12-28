class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int pprev = 1;
        int prev = 1;
        int cur = 0;

        for (int i = 2; i <= n; ++i) {
            cur = prev + pprev;
            pprev = prev;
            prev = cur;
        }

        return cur;
    }
}