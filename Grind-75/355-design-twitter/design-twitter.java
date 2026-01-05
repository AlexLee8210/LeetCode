class Twitter {
    private Map<Integer, Set<Integer>> follows;
    private List<int[]> tweets;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>(10);
        Set<Integer> following = follows.getOrDefault(userId, new HashSet<>());
        for (int i = tweets.size() - 1; i >= 0 && feed.size() < 10; --i) {
            if (!following.contains(tweets.get(i)[0]) && tweets.get(i)[0] != userId) continue;
            feed.add(tweets.get(i)[1]);
        }
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