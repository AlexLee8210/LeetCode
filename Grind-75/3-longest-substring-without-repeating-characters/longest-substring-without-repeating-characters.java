class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> vis = new HashSet<>();
        int max = 0;
        int l = 0;
        for (int r = 0; r < s.length(); ++r) {
            while (vis.contains(s.charAt(r))) {
                vis.remove(s.charAt(l++));
            }
            vis.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}