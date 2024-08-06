class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long total = 1, size = 1;
        for (int i = 1; i < nums.length; i++) {
            size = nums[i] == nums[i - 1] ? 1 : size + 1;
            total += size;
        }
        return total;
    }
}