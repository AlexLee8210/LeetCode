class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Set<Character> set = new HashSet<>();
        // int max = 0;
        // int l = 0, r = 0;
        // char[] chars = s.toCharArray();
        // while (r < chars.length) {
        //     while (r < chars.length && !set.contains(chars[r])) {
        //         set.add(chars[r++]);
        //     }
        //     max = Math.max(r - l, max);
        //     if (r == chars.length) return max;
        //     while (set.contains(chars[r])) {
        //         set.remove(chars[l++]);
        //     }
        // }
        // return max;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        char[] chars = s.toCharArray();
        for (int r = 0; r < chars.length; r++) {
            if (map.containsKey(chars[r]) && map.get(chars[r]) >= l) {
                max = Math.max(max, r - l);
                l = map.get(chars[r]) + 1;
            }
            map.put(chars[r], r);
        }
        max = Math.max(max, chars.length - l);
        return max;
    }
}