class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        boolean canUse = true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        long max = map.size() == k ? sum : 0;
        for (int r = k; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            int newLeft = map.get(nums[r - k]) - 1;
            if (newLeft == 0) {
                map.remove(nums[r - k]);
            } else {
                map.put(nums[r - k], newLeft);
            }
            sum += nums[r];
            sum -= nums[r - k];
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}