class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int n = s1.length();
        int[] freq = new int[26];
        int match = 26;
        for (char c : s1.toCharArray()) {
            if (freq[c - 'a']++ == 0) {
                --match;
            }
        }

        for (int i = 0; i < n; ++i) {
            char c = s2.charAt(i);
            --freq[c - 'a'];
            if (freq[c - 'a'] == 0) {
                ++match;
            } else if (freq[c - 'a'] == -1) {
                --match;
            }
        }
        
        if (match == 26) return true;

        for (int i = n; i < s2.length(); ++i) {
            if (++freq[s2.charAt(i - n) - 'a'] == 0) {
                ++match;
            } else if (freq[s2.charAt(i - n) - 'a'] == 1) {
                --match;
            }
            
            if (--freq[s2.charAt(i) - 'a'] == 0) {
                ++match;
            } else if (freq[s2.charAt(i) - 'a'] == -1) {
                --match;
            }

            if (match == 26) return true;
        }

        return false;
    }
}