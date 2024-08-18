class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tgt = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int matches = 0;
        String res = "";

        for (char c : t.toCharArray()) {
            tgt.put(c, tgt.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            int freq = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), freq);
            sb.append(s.charAt(i));

            if (!tgt.containsKey(s.charAt(i))) continue;

            int tgtFreq = tgt.get(s.charAt(i));
            if (freq == tgtFreq) {
                matches++;
            }

            while (matches == tgt.size()) {
                if (res.length() == 0 || sb.length() < res.length()) {
                    res = sb.toString();
                }
                freq = map.get(sb.charAt(0)) - 1;
                map.put(sb.charAt(0), freq);
                if (tgt.containsKey(sb.charAt(0)) && freq < tgt.get(sb.charAt(0))) {
                    matches--;
                }
                sb.deleteCharAt(0);
            }
        }
        return res;
    }
}