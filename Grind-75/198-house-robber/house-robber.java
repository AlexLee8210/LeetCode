class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int max = 0;
        memo[0] = nums[0];
        memo[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(memo[i - 2] + nums[i], memo[i - 1]);
        }
        return memo[nums.length - 1];
        // return helper(nums, 0, memo);
    }

    // private int helper(int[] nums, int idx, int[] memo) {
    //     if (idx >= nums.length) {
    //         return 0;
    //     }
    //     if (memo[idx] > -1) {
    //         return memo[idx];
    //     }
    //     memo[idx] = Math.max(helper(nums, idx + 1, memo), helper(nums, idx + 2, memo) + nums[idx]);
    //     return memo[idx];
    // }
}