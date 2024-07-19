class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0, memo);
    }

    private int helper(int[] nums, int idx, int[] memo) {
        if (idx >= nums.length) {
            return 0;
        }
        if (memo[idx] > -1) {
            return memo[idx];
        }
        memo[idx] = Math.max(helper(nums, idx + 1, memo), helper(nums, idx + 2, memo) + nums[idx]);
        return memo[idx];
    }
}