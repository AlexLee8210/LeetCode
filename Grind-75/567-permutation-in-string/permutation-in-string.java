class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] tgt = new int[26];
        int[] freq = new int[26];
        char[] chars = s2.toCharArray();
        int l = 0, r = 0;
        int matches = 0;
        for (char c : s1.toCharArray()) {
            tgt[c - 'a']++;
            freq[chars[r++] - 'a']++;
        }
        
        for (int i = 0; i < tgt.length; i++) {
            if (freq[i] == tgt[i]) {
                matches++;
            }
        }
        if (matches == 26) {
            return true;
        }
        for (int i = r; i < s2.length(); i++) {
            freq[chars[l] - 'a']--;
            if (freq[chars[l] - 'a'] == tgt[chars[l] - 'a']) {
                matches++;
            } else if (freq[chars[l] - 'a'] + 1 == tgt[chars[l] - 'a']) {
                matches--;
            }

            freq[chars[i] - 'a']++;
            if (freq[chars[i] - 'a'] == tgt[chars[i] - 'a']) {
                matches++;
            } else if (freq[chars[i] - 'a'] - 1 == tgt[chars[i] - 'a']) {
                matches--;
            }
            if (matches == 26) return true;
            l++;
        }
        return false;
    }
}
