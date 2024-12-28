class Solution {
    public int climbStairs(int n) {
        // int pprev = 0;
        // int prev = 0;
        // int cur = 0;

        // for (int i = 1; i <= n; ++i) {
        //     cur = prev + pprev + 1;
        //     pprev = prev;
        //     prev = cur;
        // }

        // return cur;
        if (n == 1) return 1;
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;

        for (int i = 2; i <= n; ++i) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        // System.out.println(Arrays.toString(steps));

        return steps[n];
    }
}