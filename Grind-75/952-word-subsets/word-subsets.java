class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] univ = new int[26];

        for (String s : words2) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                ++freq[c - 'a'];
            }

            for (int i = 0; i < 26; ++i) {
                univ[i] = Math.max(freq[i], univ[i]);
            }
        }

        for (String s : words1) {
            int[] freq = new int[26];
            boolean fails = false;
            for (char c : s.toCharArray()) {
                ++freq[c - 'a'];
            }

            for (int i = 0; i < 26; ++i) {
                if (univ[i] > freq[i]) {
                    fails = true;
                    break;
                }
            }

            if (!fails) {
                res.add(s);
            }
        }

        return res;
    }
}