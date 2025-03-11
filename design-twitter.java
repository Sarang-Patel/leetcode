# Design Twitter
class Twitter {
    private int timestamp = 0;

    private class Tweet {
        int time;
        int tweetId;

        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    private class TweetPointer {
        Tweet tweet;
        int userId;
        int lastIdx;

        public TweetPointer(Tweet tweet, int userId, int lastIdx) {
            this.tweet = tweet;
            this.userId = userId;
            this.lastIdx = lastIdx;
        }
    }

    private HashMap<Integer, Set<Integer>> followMap;
    private HashMap<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(timestamp++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        PriorityQueue<TweetPointer> q = new PriorityQueue<>(
                (a, b) -> b.tweet.time - a.tweet.time);

        for (int followee : followMap.get(userId)) {
            List<Tweet> tweets = tweetMap.get(followee);
            if (tweets != null && !tweets.isEmpty()) {
                int lastIdx = tweets.size() - 1;
                q.offer(new TweetPointer(tweets.get(lastIdx), followee, lastIdx));
            }
        }

        while (!q.isEmpty() && res.size() < 10) {
            TweetPointer tweetPointer = q.poll();
            res.add(tweetPointer.tweet.tweetId);

            if (tweetPointer.lastIdx > 0) {
                List<Tweet> tweets = tweetMap.get(tweetPointer.userId);
                q.offer(new TweetPointer(tweets.get(tweetPointer.lastIdx - 1), tweetPointer.userId,
                        tweetPointer.lastIdx - 1));
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;

        Set<Integer> followees = followMap.get(followerId);
        if (followees != null && !followees.isEmpty()) {
            followees.remove(followeeId);
        }
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