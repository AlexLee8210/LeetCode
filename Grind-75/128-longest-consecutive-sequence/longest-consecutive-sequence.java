class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int k : set) {
            if (set.contains(k - 1)) continue;
            int n = k;
            do {
                n++;
            } while (set.contains(n));
            max = Math.max(n - k, max);
        }
        return max;
    }
}