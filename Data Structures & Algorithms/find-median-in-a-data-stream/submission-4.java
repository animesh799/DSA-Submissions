class MedianFinder {

    // Max heap contains the smaller half
    // Largest element of smaller half is at the top
    PriorityQueue<Integer> maxHeap;

    // Min heap contains the larger half
    // Smallest element of larger half is at the top
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a, b)
        );
    }

    public void addNum(int num) {

        int sizeMin = minHeap.size();
        int sizeMax = maxHeap.size();

        // First element goes into maxHeap
        if (sizeMax == 0) {
            maxHeap.offer(num);
            return;
        }

        // num belongs to the smaller half
        if (maxHeap.peek() >= num) {

            maxHeap.offer(num);

            // maxHeap can have at most one extra element
            if ((sizeMax + 1) - sizeMin > 1) {
                minHeap.offer(maxHeap.poll());
            }

        } else {

            // num belongs to the larger half
            minHeap.offer(num);

            // maxHeap should always have equal or
            // one more element than minHeap
            if ((sizeMin + 1) - sizeMax > 0) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {

        int sizeMin = minHeap.size();
        int sizeMax = maxHeap.size();

        // Odd number of elements
        if (sizeMax > sizeMin) {
            return (double) maxHeap.peek();
        }

        // Even number of elements
        return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    }
}