class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int r = 0; r < nums.length; ++r) {
            cur += nums[r];
            res = Math.max(cur, res);
            if (cur < 0) cur = 0;
        }

        return res;
    }
}