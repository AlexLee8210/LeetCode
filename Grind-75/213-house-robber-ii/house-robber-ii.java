class Solution {
    // [low, high]
    private int robRange(int[] nums, int low, int high) {
        int exclude = 0, include = 0;
        for (int i = low; i <= high; ++i) {
            int in = include, ex = exclude;
            include = exclude + nums[i];
            exclude = Math.max(in, ex);
        }

        return Math.max(include, exclude);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }
}