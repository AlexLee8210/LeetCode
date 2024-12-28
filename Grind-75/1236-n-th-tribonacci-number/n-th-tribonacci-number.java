class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int ppprev = 0;
        int pprev = 1;
        int prev = 1;
        int cur = 0;

        for (int i = 3; i <= n; ++i) {
            cur = prev + pprev + ppprev;
            ppprev = pprev;
            pprev = prev;
            prev = cur;
        }

        return cur;
    }
}