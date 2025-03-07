class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<>();
        int l = 0, r = 0;
        int max = 0;
        while (r < s.length()) {
            int lastIndex = seen.getOrDefault(s.charAt(r), -1);
            if (lastIndex >= l) {
                max = Math.max(max, r - l);
                l = lastIndex + 1;
            }

            seen.put(s.charAt(r), r);
            ++r;
        }

        return Math.max(max, s.length() - l);
    }
}