class Solution {
    public int numSplits(String s) {
        boolean[] seen = new boolean[26];
        int[] uright = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; --i) {
            int key = s.charAt(i) - 'a';
            if (!seen[key]) {
                uright[i] = uright[i + 1] + 1;
            } else {
                uright[i] = uright[i + 1];
            }
            seen[key] = true;
        }

        seen = new boolean[26];
        int uleft = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            int key = s.charAt(i) - 'a';
            if (!seen[key]) ++uleft;
            if (uright[i + 1] == uleft) {
                ++cnt;
            }
            seen[key] = true;
        }

        return cnt;
    }
}