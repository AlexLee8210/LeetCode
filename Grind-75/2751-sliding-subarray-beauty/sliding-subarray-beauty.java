class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] subs = new int[nums.length - k + 1];
        int[] freq = new int[101];
        for (int i = 0; i < k; i++) {
            freq[nums[i] + 50]++;
        }

        int cnt = x;
        for (int i = 0; i < freq.length; i++) {
            cnt -= freq[i];
            if (cnt <= 0) {
                subs[0] = Math.min(i - 50, 0);
                break;
            }
        }

        for (int r = k; r < nums.length; r++) {
            freq[nums[r] + 50]++;
            freq[nums[r - k] + 50]--;
            cnt = x;
            for (int i = 0; i < freq.length; i++) {
                cnt -= freq[i];
                if (cnt <= 0) {
                    subs[r - k + 1] = Math.min(i - 50, 0);
                    break;
                }
            }
        }
        return subs;
    }
}