class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0;
        long length = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                cnt += ++length;
            } else if (length > 0) {
                length = 0;
            }
        }
        return cnt;
    }
}