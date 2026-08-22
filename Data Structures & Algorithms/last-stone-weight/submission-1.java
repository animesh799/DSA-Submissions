class Solution {

    public int lastStoneWeight(int[] stones) {

        // Max heap: largest stone stays at the top.
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // Add all stones.
        for (int stone : stones) {
            pq.offer(stone);
        }


        // Continue until at most one stone remains.
        while (pq.size() > 1) {

            // Get two heaviest stones.
            int stone1 = pq.poll();
            int stone2 = pq.poll();


            // If they are different, the difference
            // becomes a new stone.
            if (stone1 != stone2) {
                pq.offer(stone1 - stone2);
            }
        }


        // If no stone remains → 0
        // Otherwise → remaining stone.
        return pq.isEmpty() ? 0 : pq.peek();
    }
}