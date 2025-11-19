class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] freq = new int[26];

        for (int i = 0; i < p.length(); ++i) {
            --freq[p.charAt(i) - 'a'];
            ++freq[s.charAt(i) - 'a'];
        }

        if (isZero(freq)) res.add(0);

        for (int i = p.length(); i < s.length(); ++i) {
            char r = s.charAt(i);
            char l = s.charAt(i - p.length());
            
            --freq[l - 'a'];
            ++freq[r - 'a'];

            if (isZero(freq)) {
                res.add(i - p.length() + 1);
            }
        }

        return res;
    }

    private boolean isZero(int[] arr) {
        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;
    }
}