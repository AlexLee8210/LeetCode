class Twitter {
    List<int[]>[] tweets;
    Set<Integer>[] following;
    private int time;

    public Twitter() {
        tweets = new List[501];
        following = new Set[501];
        time = -1;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (tweets[userId] == null) {
            follow(userId, userId);
            tweets[userId] = new ArrayList<>();
        }
        tweets[userId].add(new int[]{tweetId, ++time});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (following[userId] == null) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int followeeId : following[userId]) {
            if (tweets[followeeId] == null) continue;
            
            List<int[]> tweetList = tweets[followeeId];
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
        if (following[followerId] == null) {
            following[followerId] = new HashSet<>();
        }
        following[followerId].add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following[followerId] == null) {
            following[followerId] = new HashSet<>();
        }
        following[followerId].remove(followeeId);
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