class Solution {
    public int equalCountSubstrings(String s, int count) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int u = 1; u <= 26; u++) {
            int[] freq = new int[26];
            int len = count * u;
            if (len > chars.length) break;
            int matches = 0;
            for (int i = 0; i < len; i++) {
                freq[chars[i] - 'a']++;
                if (freq[chars[i] - 'a'] == count) {
                    matches++;
                } else if (freq[chars[i] - 'a'] - 1 == count) {
                    matches--;
                }
            }
            if (matches == u) res++;
            for (int i = len; i < chars.length; i++) {
                freq[chars[i - len] - 'a']--;
                if (freq[chars[i - len] - 'a'] == count) {
                    matches++;
                } else if (freq[chars[i - len] - 'a'] + 1 == count) {
                    matches--;
                }
                freq[chars[i] - 'a']++;
                if (freq[chars[i] - 'a'] == count) {
                    matches++;
                } else if (freq[chars[i] - 'a'] - 1 == count) {
                    matches--;
                }
                if (matches == u) res++;
            }
        }
        return res;
    }
}