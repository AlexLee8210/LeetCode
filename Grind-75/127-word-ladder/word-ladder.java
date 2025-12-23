class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> dq = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        dq.addLast(beginWord);
        int dist = 0;

        while (!dq.isEmpty()) {
            ++dist;
            int size = dq.size();
            for (int i = 0; i < size; ++i) {
                String cur = dq.pollFirst();
                if (vis.contains(cur)) continue;
                if (cur.equals(endWord)) return dist;
                vis.add(cur);
                for (String word : wordList) {
                    if (vis.contains(word)) continue;
                    if (canTransform(cur, word)) {
                        dq.addLast(word);
                    }
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