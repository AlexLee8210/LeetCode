class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ans = 0;
        int l = 0;
        int maxf = 0;
        for (int r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            ++freq[c - 'A'];
            maxf = Math.max(maxf, freq[c - 'A']);

            if ((r - l + 1) - maxf > k) {
                --freq[s.charAt(l) - 'A'];
                ++l;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}