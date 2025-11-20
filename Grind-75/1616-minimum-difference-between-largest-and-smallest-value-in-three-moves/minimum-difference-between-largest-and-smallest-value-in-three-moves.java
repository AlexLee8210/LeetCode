class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; ++i) {
            int imax = nums.length - (3 - i) - 1;
            int diff = nums[imax] - nums[i];
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }
}