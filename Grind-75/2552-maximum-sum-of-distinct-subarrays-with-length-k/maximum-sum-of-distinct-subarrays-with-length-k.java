class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] freq = new int[(int) Math.pow(10, 5) + 1];
        long res = 0;
        long sum = 0;
        int distinct = 0;
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
            sum += nums[i];
            if (freq[nums[i]] == 1) {
                distinct++;
            }
        }

        if (distinct == k) {
            res = Math.max(res, sum);
        }
        for (int i = k; i < nums.length; i++) {
            freq[nums[i - k]]--;
            if (freq[nums[i - k]] == 0) {
                distinct--;
            }
            freq[nums[i]]++;
            if (freq[nums[i]] == 1) {
                distinct++;
            }
            sum += nums[i] - nums[i - k];
            if (distinct == k) {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}