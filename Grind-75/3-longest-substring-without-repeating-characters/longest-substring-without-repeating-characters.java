class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0, r = 0;
        int max = 0;
        while (r < s.length()) {
            if (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                ++l;
                continue;
            }

            seen.add(s.charAt(r));
            ++r;
            max = Math.max(max, r - l);
        }

        return max;
    }
}