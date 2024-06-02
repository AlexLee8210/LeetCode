class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l = 0, r = 0;
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            while (r < chars.length && !set.contains(chars[r])) {
                set.add(chars[r++]);
            }
            max = Math.max(r - l, max);
            if (r == chars.length) return max;
            while (set.contains(chars[r])) {
                set.remove(chars[l++]);
            }
        }
        return max;
    }
}