class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        Set<Character> seen = new HashSet<>();
        for (int r = 0; r < s.length(); ++r) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l++));
            }
            max = Math.max(max, r - l + 1);
            seen.add(s.charAt(r));
        }

        return Math.max(max, s.length() - l);
    }
}