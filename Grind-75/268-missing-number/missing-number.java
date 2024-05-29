class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (inRange(nums[i], nums.length)) {
                sum -= nums[i];
            }
        }
        return sum;
    }
    private boolean inRange(int n, int range) {
        return n <= range && n >= 0;
    }
}