class Solution {
    public int minimumOperations(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ops = 0;
        while (l < r) {
            int left = nums[l++];
            int right = nums[r--];
            while (l <= r && left != right) {
                if (left < right) {
                    left += nums[l++];
                } else {
                    right += nums[r--];
                }
                ++ops;
            }
            if (left != right) ++ops;
        }

        return ops;
    }
}