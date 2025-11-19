class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int pp = nums[0];
        int p = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {
            int tmp = p;
            p = Math.max(nums[i] + pp, p);
            pp = tmp;
        }

        return p;
    }
}