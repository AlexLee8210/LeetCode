class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] ans = new int[nums.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            if (Math.abs(nums[l]) > nums[r]) {
                ans[i] = (int) Math.pow(nums[l++], 2);
            } else {
                ans[i] = (int) Math.pow(nums[r--], 2);
            }
        }
        return ans;
    }
}