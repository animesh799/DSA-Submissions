class Twitter {
    Map<Integer, Set<Integer>> followingMap;
    Map<Integer, List<Triple>> tweetMap;
    private long ts=0;

    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (tweetMap.get(userId) == null) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new Triple(userId, tweetId, ts));
        ts++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Triple> pq=new PriorityQueue<>((a, b) ->Long.compare(b.ts,a.ts));

        List<Triple> tweets=tweetMap.get(userId);

if(tweets!=null){
pq.addAll(tweets);
}
        
        if(followingMap.get(userId)!=null){
                  for(Integer follower:followingMap.get(userId)){
            List<Triple> folTweets=tweetMap.get(follower);
            pq.addAll(folTweets);
        }
        }


        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < 10&&!pq.isEmpty(); i++) {
            Triple poll = pq.poll();
            res.add(poll.tweetId);
        }


        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followingMap.get(followerId) == null) {
            followingMap.put(followerId, new HashSet<>());
        }
        followingMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followingMap.get(followerId) != null) {
            followingMap.get(followerId).remove(followeeId);
        }
    }

    public class Triple {
        int userId, tweetId;
        long ts;
        public Triple(int userId, int tweetId, long ts) {
            this.userId = userId;
            this.ts = ts;
            this.tweetId = tweetId;
        }
    }
}
