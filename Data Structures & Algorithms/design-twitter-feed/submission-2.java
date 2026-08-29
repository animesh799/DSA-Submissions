class Twitter {

    // follower -> set of users that this follower follows
    Map<Integer, Set<Integer>> followingMap;

    // user -> list of tweets posted by that user
    Map<Integer, List<Triple>> tweetMap;

    // Global timestamp to maintain the order of tweets
    private long ts = 0;

    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        // Create tweet list for the user if it doesn't exist
        if (tweetMap.get(userId) == null) {
            tweetMap.put(userId, new ArrayList<>());
        }

        // Store tweet along with timestamp
        tweetMap.get(userId).add(
            new Triple(userId, tweetId, ts)
        );

        // Increment timestamp for the next tweet
        ts++;
    }

    public List<Integer> getNewsFeed(int userId) {

        // Max heap:
        // Tweet with the latest timestamp comes first
        PriorityQueue<Triple> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(b.ts, a.ts)
            );

        // Add user's own tweets
        List<Triple> tweets = tweetMap.get(userId);

        if (tweets != null) {
            pq.addAll(tweets);
        }

        // Add tweets from all users that this user follows
        Set<Integer> followees = followingMap.get(userId);

        if (followees != null) {

            for (Integer followee : followees) {

                List<Triple> followeeTweets =
                    tweetMap.get(followee);

                // The followee may not have posted any tweet
                if (followeeTweets != null) {
                    pq.addAll(followeeTweets);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        // Extract the 10 most recent tweets
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            Triple poll = pq.poll();
            res.add(poll.tweetId);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        // Create followee set for follower if it doesn't exist
        if (followingMap.get(followerId) == null) {
            followingMap.put(followerId, new HashSet<>());
        }

        // Add followee to follower's following list
        followingMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        // Remove followee from follower's following list
        if (followingMap.get(followerId) != null) {
            followingMap.get(followerId).remove(followeeId);
        }
    }

    public class Triple {

        int userId;
        int tweetId;
        long ts;

        public Triple(int userId, int tweetId, long ts) {
            this.userId = userId;
            this.ts = ts;
            this.tweetId = tweetId;
        }
    }
}