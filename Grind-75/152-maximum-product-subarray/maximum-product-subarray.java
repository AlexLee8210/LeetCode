class Solution {
    public int maxProduct(int[] nums) {
        long l = 0, r = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1 - i;
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[j];
            if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
                l /= nums[i];
            }if (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) {
                r /= nums[i];
            }
            max = Math.max(max, (int) Math.max(l, r));
        }
        return max;
    }
}