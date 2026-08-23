class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // Max heap:
        // Farthest point among the current k points
        // stays at the top.
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            k,
            (a, b) -> Double.compare(
                findDistance(b[0], b[1]),
                findDistance(a[0], a[1])
            )
        );


        for (int[] point : points) {

            // Fill heap until we have k points
            if (pq.size() < k) {

                pq.offer(point);

            } else {

                // Farthest point among current k points
                int[] peek = pq.peek();

                double dist1 = findDistance(peek[0], peek[1]);
                double dist2 = findDistance(point[0], point[1]);

                // Current point is closer
                if (dist1 > dist2) {

                    pq.poll();
                    pq.offer(point);
                }
            }
        }


        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }


    private double findDistance(int x, int y) {

        return Math.sqrt(x * x + y * y);
    }
}