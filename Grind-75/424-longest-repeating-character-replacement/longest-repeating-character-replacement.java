class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqCnt = 0;
        int l = 0;
        char[] chars = s.toCharArray();
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            freq[chars[r] - 'A']++;
            mostFreqCnt = Math.max(mostFreqCnt, freq[chars[r] - 'A']);
            if ((r - l + 1) - mostFreqCnt > k) {
                freq[chars[l++] - 'A']--;
            } else {
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}