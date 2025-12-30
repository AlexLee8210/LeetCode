class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> vis = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int r = 0; r < s.length(); ++r) {
            if (vis.containsKey(s.charAt(r))) {
                l = Math.max(l, vis.remove(s.charAt(r)) + 1);
            }
            vis.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}