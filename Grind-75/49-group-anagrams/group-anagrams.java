class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String k : strs) {
            String key = getKey(k);
            if (map.containsKey(key)) {
                map.get(key).add(k);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(k);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private String getKey(String k) {
        char[] chars = new char[26];
        for (char c : k.toCharArray()) {
            chars[c - 'a']++;
        }
        String key = new String(chars);
        return key;
    }
}