class Solution {
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            ++freq[c - 'a'];
        }

        int maxC = 0;
        int maxV = 0;
        for (char c : vowels) {
            maxV = Math.max(freq[c - 'a'], maxV);
        }

        for (int i = 0; i < 26; ++i) {
            boolean vowel = false;
            for (char v : vowels) {
                if (v - 'a' == i) {
                    vowel = true;
                    break;
                }
            }
            if (vowel) continue;
            maxC = Math.max(maxC, freq[i]);
        }

        return maxC + maxV;
    }
}