class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        return (long) k * (max - min);
    }
}