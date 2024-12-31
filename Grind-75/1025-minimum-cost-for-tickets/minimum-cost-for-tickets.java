class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length - 1] + 1;
        int[] dp = new int[max];
        boolean[] travel = new boolean[max];

        for (int day : days) {
            travel[day] = true;
        }

        for (int i = 1; i < max; ++i) {
            if (!travel[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
        }

        return dp[max - 1];
    }
}