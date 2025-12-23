class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> dq = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        dq.addLast(beginWord);
        int dist = 0;

        while (!dq.isEmpty()) {
            ++dist;
            int size = dq.size();
            for (int i = 0; i < size; ++i) {
                String cur = dq.pollFirst();
                if (cur.equals(endWord)) return dist;
                
                // for (String word : wordList) {
                //     if (vis.contains(word)) continue;
                //     if (canTransform(cur, word)) {
                //         dq.addLast(word);
                //         vis.add(word);
                //     }
                // }
                char[] newWord = cur.toCharArray();
                for (int j = 0; j < cur.length(); ++j) {
                    char tmp = newWord[j];
                    for (int k = 'a'; k <= 'z'; ++k) {
                        newWord[j] = (char) k;
                        String word = new String(newWord);
                        if (wordSet.contains(word) && !vis.contains(word)) {
                            dq.addLast(word);
                            vis.add(word);
                        }
                    }
                    newWord[j] = tmp;
                }
            }
        }
        return 0;
    }

    private boolean canTransform(String a, String b) {
        boolean diff = false;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == b.charAt(i)) continue;
            if (diff) return false;
            diff = true;
        }
        return diff;
    }
}