class Twitter {

    // follower -> users they follow
    Map<Integer, Set<Integer>> followingMap;

    // user -> latest tweet
    Map<Integer, Tweet> tweetMap;

    private int ts = 0;

    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        // New tweet becomes the latest tweet of this user
        Tweet tweet = new Tweet(
            tweetId,
            ts++,
            tweetMap.get(userId)
        );

        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        // Max heap based on timestamp
        PriorityQueue<Tweet> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(b.ts, a.ts)
            );

        // Add user's latest tweet
        if (tweetMap.containsKey(userId)) {
            pq.offer(tweetMap.get(userId));
        }

        // Add latest tweet of every followee
        Set<Integer> followees = followingMap.get(userId);

        if (followees != null) {
            for (Integer followee : followees) {

                if (tweetMap.containsKey(followee)) {
                    pq.offer(tweetMap.get(followee));
                }
            }
        }

        // We need only 10 tweets
        while (!pq.isEmpty() && res.size() < 10) {

            // Get the newest tweet
            Tweet current = pq.poll();

            res.add(current.tweetId);

            // Add the next older tweet from the same user
            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        if (!followingMap.containsKey(followerId)) {
            followingMap.put(
                followerId,
                new HashSet<>()
            );
        }

        followingMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }

    class Tweet {

        int tweetId;
        int ts;

        // Next older tweet of the same user
        Tweet next;

        Tweet(int tweetId, int ts, Tweet next) {
            this.tweetId = tweetId;
            this.ts = ts;
            this.next = next;
        }
    }
}