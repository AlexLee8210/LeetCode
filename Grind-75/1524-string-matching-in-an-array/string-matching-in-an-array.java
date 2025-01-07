class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            if (isSub(words, i)) {
                res.add(words[i]);
            }
        }

        return res;
    }

    private boolean isSub(String[] words, int index) {
        String word = words[index];
        for (int i = 0; i < words.length; ++i) {
            if (index == i) continue;
            if (words[i].contains(word)) return true;
        }

        return false;
    }
}