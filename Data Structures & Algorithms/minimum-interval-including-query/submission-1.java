class Solution {

    public int[] minInterval(int[][] intervals, int[] queries) {

        int n = queries.length;

        // [query value, original index]
        int[][] sortedQuery = new int[n][2];


        // Sort intervals by start time
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );


        // Store query + original index
        for (int i = 0; i < n; i++) {

            sortedQuery[i][0] = queries[i];
            sortedQuery[i][1] = i;
        }


        // Sort queries by query value
        Arrays.sort(
            sortedQuery,
            (a, b) -> Integer.compare(a[0], b[0])
        );


        // Min heap based on interval size
        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(
                    a[1] - a[0],
                    b[1] - b[0]
                )
            );


        int[] res = new int[n];

        int p1 = 0;


        // Process queries in sorted order
        for (int i = 0; i < n; i++) {

            int query = sortedQuery[i][0];
            int originalIndex = sortedQuery[i][1];


            // -----------------------------------------------------
            // Add all intervals that start <= query.
            // -----------------------------------------------------
            while (
                p1 < intervals.length &&
                intervals[p1][0] <= query
            ) {

                pq.offer(intervals[p1]);

                p1++;
            }


            // -----------------------------------------------------
            // Remove intervals that end before query.
            // -----------------------------------------------------
            while (
                !pq.isEmpty() &&
                pq.peek()[1] < query
            ) {

                pq.poll();
            }


            // -----------------------------------------------------
            // Heap top = smallest valid interval.
            // -----------------------------------------------------
            if (pq.isEmpty()) {

                res[originalIndex] = -1;

            } else {

                int[] interval = pq.peek();

                res[originalIndex] =
                    interval[1] - interval[0] + 1;
            }
        }


        return res;
    }
}