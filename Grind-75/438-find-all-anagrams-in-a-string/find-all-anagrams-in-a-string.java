class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            int newVal = map.getOrDefault(c, 0) - 1;
            if (newVal == 0) {
                map.remove(c);
            } else {
                map.put(c, newVal);
            }
        }
        HashMap<Character, Integer> tempMap = new HashMap<>(map);
        for (int r = p.length(); r < s.length(); r++) {
            int l = r - p.length();
            if (map.size() == 0) {
                res.add(l);
            }
            map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
            if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));

            char c = s.charAt(r);
            int newVal = map.getOrDefault(c, 0) - 1;
            if (newVal == 0) {
                map.remove(c);
            } else {
                map.put(c, newVal);
            }
        }
        if (map.size() == 0) {
            res.add(s.length() - p.length());
        }
        return res;
    }
}