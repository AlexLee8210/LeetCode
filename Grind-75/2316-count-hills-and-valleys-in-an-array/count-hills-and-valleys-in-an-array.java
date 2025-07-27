class Solution {
    public int countHillValley(int[] nums) {
        int cnt = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) continue;
            if (prev < nums[i] && nums[i + 1] < nums[i]) ++cnt;
            else if (prev > nums[i] && nums[i + 1] > nums[i]) ++cnt;

            prev = nums[i];
        }

        return cnt;
    }
}