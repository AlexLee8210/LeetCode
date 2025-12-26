class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> nToLen = new HashMap<>();
        for (int n : nums) {
            if (nToLen.containsKey(n)) continue;
            int left = nToLen.getOrDefault(n - 1, 0);
            int right = nToLen.getOrDefault(n + 1, 0);
            int ln = n - left;
            int rn = n + right;
            int len = left + right + 1;
            nToLen.put(ln, len);
            nToLen.put(rn, len);
            nToLen.put(n, len);
            max = Math.max(len, max);
        }
        return max;
    }
}