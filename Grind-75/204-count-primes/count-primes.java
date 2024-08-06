class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (vis[i]) continue;

            cnt++;
            vis[i] = true;
            for (long j = (long)i * i; j < n; j += i) {
                vis[(int)j] = true;
            }
        }
        return cnt;
    }
}