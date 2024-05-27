class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] lets = new int[26];
        for (char c : s.toCharArray()) {
            lets[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            lets[c - 'a']--;
            if (lets[c - 'a'] < 0) return false;
        }
        return true;
    }
}