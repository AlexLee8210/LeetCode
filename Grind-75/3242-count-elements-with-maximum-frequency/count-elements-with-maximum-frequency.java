class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int maxCnt = 0;
        int[] freq = new int[101];
        for (int i = 0; i < nums.length; ++i) {
            if (++freq[nums[i]] > maxFreq) {
                maxFreq = freq[nums[i]];
                maxCnt = 1;
            } else if (freq[nums[i]] == maxFreq) {
                ++maxCnt;
            }
        }

        return maxFreq * maxCnt;
    }
}