class Twitter {

    HashMap<Integer, List<int[]>> tweets;
    HashMap<Integer, Set<Integer>> following;
    private int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = -1;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> {
            follow(userId, userId);
            return new ArrayList<>();
        });
        tweets.get(userId).add(new int[]{tweetId, ++time});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!following.containsKey(userId)) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int follweeId : following.get(userId)) {
            if (!tweets.containsKey(follweeId)) continue;
            List<int[]> tweetList = tweets.get(follweeId);
            for (int i = tweetList.size() - 1; i >= 0; --i) {
                if (pq.size() == 10 && tweetList.get(i)[1] < pq.peek()[1]) break;
                pq.offer(tweetList.get(i));
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        while (!pq.isEmpty()) {
            res.addFirst(pq.poll()[0]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>());
        following.get(followerId).remove(followeeId);
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