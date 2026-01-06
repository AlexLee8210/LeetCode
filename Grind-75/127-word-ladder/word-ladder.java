class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        // Set<String> vis = new HashSet<>();
        boolean[] vis = new boolean[wordList.size()];
        queue.offer(beginWord);

        int len = 0;
        while (!queue.isEmpty()) {
            ++len;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String src = queue.poll();
                if (src.equals(endWord)) return len;
                for (int j = 0; j < wordList.size(); ++j) {
                    String dst = wordList.get(j);
                    if (vis[j]) continue;
                    if (isValidNextWord(src, dst)) {
                        queue.offer(dst);
                        vis[j] = true;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isValidNextWord(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++diff == 2) return false;
            }
        }
        return true;
    }
}