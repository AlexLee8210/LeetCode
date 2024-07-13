class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
            freq[s.charAt(i) - 'a']--;
        }

        int l = 0;
        if (isAnagram(freq)) res.add(0);
        for (int r = p.length(); r < s.length(); r++) {
            freq[s.charAt(l++) - 'a']++;
            freq[s.charAt(r) - 'a']--;
            if (isAnagram(freq)) res.add(l);
        }
        return res;
    }

    private boolean isAnagram(int[] freq) {
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }
}