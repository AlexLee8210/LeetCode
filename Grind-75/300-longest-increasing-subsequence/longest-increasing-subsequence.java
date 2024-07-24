class Solution {
    public int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            max = 1;
            for (int k : map.keySet()) {
                if (k > nums[i]) {
                    max = Math.max(max, map.get(k) + 1);
                }
            }
            map.put(nums[i], max);
            maxLength = Math.max(max, maxLength);
        }
        return maxLength;
        // return helper(nums, 0, 0, Long.MIN_VALUE);
    }

    // private int helper(int[] nums, int index, int len, long last) {
    //     if (index == nums.length) return len;
    //     int notChoose = helper(nums, index + 1, len, last);
    //     if ((long) nums[index] > last) {
    //         return Math.max(notChoose, helper(nums, index + 1, len + 1, nums[index]));
    //     }
    //     return notChoose;
    // }
}