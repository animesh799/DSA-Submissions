class Twitter {

    // follower -> set of users that this follower follows
    Map<Integer, Set<Integer>> followingMap;

    // user -> list of tweets posted by that user
    Map<Integer, Tweet> tweetMap;

    // Global timestamp to maintain the order of tweets
    private long ts = 0;

    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        // Create tweet list for the user if it doesn't exist
        // if (tweetMap.get(userId) == null) {
        //     tweetMap.put(userId, new ArrayList<>());
        // }

        // Store tweet along with timestamp
        tweetMap.put(userId,
            new Tweet(tweetId, ts,tweetMap.get(userId))
        );

        // Increment timestamp for the next tweet
        ts++;
    }

    public List<Integer> getNewsFeed(int userId) {

        // Max heap:
        // Tweet with the latest timestamp comes first
        PriorityQueue<Tweet> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(b.ts, a.ts)
            );

        // Add user's own tweets
        Tweet tweet = tweetMap.get(userId);

        if (tweet != null) {
            pq.offer(tweet);
        }

        // Add tweets from all users that this user follows
        Set<Integer> followees = followingMap.get(userId);

        if (followees != null) {

            for (Integer followee : followees) {

                Tweet followeeTweet =
                    tweetMap.get(followee);

                // The followee may not have posted any tweet
                if (followeeTweet != null) {
                    pq.offer(followeeTweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        // Extract the 10 most recent tweets
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            Tweet poll = pq.poll();
            res.add(poll.tweetId);
            if(poll.next!=null){
               pq.offer(poll.next);
            }
            
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

    public class Tweet {
        int tweetId;
        long ts;
        Tweet next;

        public Tweet(int tweetId, long ts,Tweet next) {
            this.next = next;
            this.ts = ts;
            this.tweetId = tweetId;
        }
    }
}