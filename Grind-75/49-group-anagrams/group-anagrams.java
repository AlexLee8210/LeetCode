class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = toKey(str);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
                res.add(list);
            }
            List<String> anagrams = map.get(key);
            anagrams.add(str);
        }

        return res;
    }

    private String toKey(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            ++freq[c - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (freq[i] != 0) {
                sb.append((char) i + 'a').append(freq[i]);
            }
        }

        return sb.toString();
    }
}