class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long sum = 0;
        for (int k : nums) {
            sum += k;
        }

        int count = 0;
        long cur = 0;
        for (int i = 0; i < n - 1; ++i) {
            cur += nums[i];
            if (cur >= sum - cur) {
                ++count;
            }
        }
        return count;
    }
}