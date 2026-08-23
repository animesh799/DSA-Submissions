class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort by end time.
        // We always want to keep the interval
        // that finishes earliest.
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[1], b[1])
        );


        int removals = 0;

        // First interval is initially selected.
        int[] prev = intervals[0];


        for (int i = 1; i < intervals.length; i++) {

            int[] curr = intervals[i];


            // Overlap:
            //
            // curr starts before prev finishes.
            if (curr[0] < prev[1]) {

                // Remove curr.
                //
                // Keep prev because prev ends earlier
                // due to our sorting.
                removals++;

            }
            else {

                // No overlap.
                //
                // Keep curr as the latest selected interval.
                prev = curr;
            }
        }


        return removals;
    }
}