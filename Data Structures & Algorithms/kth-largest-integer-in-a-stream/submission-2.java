class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;

        // Min heap
        // We only keep k largest elements.
        pq = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }


    public int add(int val) {

        // If we don't have k elements yet,
        // simply add the new element.
        if (pq.size() < k) {

            pq.offer(val);

        }
        // If val is larger than the smallest
        // element among our k largest elements,
        // replace that smallest element.
        else if (val > pq.peek()) {

            pq.poll();
            pq.offer(val);
        }

        // Smallest element in our k-element min heap
        // is the kth largest element overall.
        return pq.peek();
    }
}