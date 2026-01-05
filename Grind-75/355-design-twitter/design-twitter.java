class Twitter {
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<int[]>> tweets;
    private int time;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
            follow(userId, userId);
        }
        tweets.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>(10);
        Set<Integer> following = follows.get(userId);
        if (following == null) return feed;

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int followeeId : following) {
            List<int[]> cur = tweets.get(followeeId);
            if (cur == null) continue;

            for (int i = cur.size() - 1; i >= 0; --i) {
                if (minheap.size() == 10 && cur.get(i)[0] < minheap.peek()[0]) break;

                minheap.add(cur.get(i));
                if (minheap.size() > 10) minheap.poll();
            }
        }

        while (!minheap.isEmpty()) {
            feed.add(minheap.poll()[1]);
        }

        Collections.reverse(feed);

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) follows.put(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) return;
        follows.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */