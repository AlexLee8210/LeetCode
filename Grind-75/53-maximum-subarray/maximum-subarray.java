class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int cur = nums[0];
        for (int r = 1; r < nums.length; ++r) {
            if (cur < 0) cur = 0;
            cur += nums[r];
            res = Math.max(cur, res);
        }

        return res;
    }
}