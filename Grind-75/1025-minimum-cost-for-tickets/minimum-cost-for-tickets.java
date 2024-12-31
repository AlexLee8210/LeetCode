class Solution {
    private int[] tickets = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        // int max = days[days.length - 1];
        // int[][] min = new int[max + 1][3];

        // for (int i = 0; )
        int[] memo = new int[days[days.length - 1] + 1];
        return helper(0, days, costs, memo);
    }

    private int helper(int index, int[] days, int[] costs, int[] memo) {
        if (index >= days.length) return 0;
        if (memo[index] != 0) return memo[index];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; ++i) {
            int nextIndex = bs(days, days[index] + tickets[i]);
            int cost = helper(nextIndex, days, costs, memo) + costs[i];
            min = Math.min(min, cost);
        }

        memo[index] = min;
        return min;
    }

    // private int bs(int[] arr, int target, int start) {
    //     for (int i = start; i < arr.length; ++i) {
    //         if (arr[i] >= target) return i;
    //     }
    //     return Integer.MAX_VALUE;
    // }

    private int bs(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        if (target > arr[r]) return Integer.MAX_VALUE;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}