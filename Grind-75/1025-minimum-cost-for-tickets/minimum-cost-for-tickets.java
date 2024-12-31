class Solution {
    private int[] tickets = new int[]{1, 7, 30};

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
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < costs.length; ++j) {
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - tickets[j])] + costs[j]);
            }
        }

        return dp[max - 1];
    }
}