class Solution {

    public int findKthLargest(int[] nums, int k) {

        // Min heap containing only the k largest elements.
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(k, Integer::compare);

        for (int num : nums) {

            // Fill the heap initially.
            if (pq.size() < k) {

                pq.offer(num);

            }
            // If current number is larger than the
            // smallest of our k largest elements,
            // replace that smallest element.
            else if (num > pq.peek()) {

                pq.poll();
                pq.offer(num);
            }
        }

        // Smallest element among the k largest
        // = kth largest element.
        return pq.peek();
    }
}