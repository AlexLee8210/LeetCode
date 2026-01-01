class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int[] res = new int[]{-1, Integer.MAX_VALUE - 1};
        int matches = 0;
        int l = 0;
        for (int r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            if (!tFreq.containsKey(c)) continue;
            int newf = sFreq.getOrDefault(c, 0) + 1;
            int matchf = tFreq.get(c);
            sFreq.put(c, newf);
            if (newf == matchf) {
                ++matches;
            }

            while (matches >= tFreq.size()) {
                char lc = s.charAt(l);
                if (!tFreq.containsKey(lc)) {
                    ++l;
                    continue;
                }

                if (res[1] - res[0] > r - l) {
                    res[0] = l;
                    res[1] = r;
                }

                sFreq.put(lc, sFreq.get(lc) - 1);
                ++l;

                if (sFreq.get(lc) == tFreq.get(lc) - 1) {
                    --matches;
                }
            }
        }

        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}