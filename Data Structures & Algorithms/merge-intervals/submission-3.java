class Solution {

    public int[][] merge(int[][] intervals) {

        // Sort by start time
        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[0], b[0]));


        List<int[]> result = new ArrayList<>();


        // Current merged interval
        int[] current = intervals[0];


        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];


            // --------------------------------------------------
            // No overlap
            //
            // Example:
            // current = [1,3]
            // next    = [5,7]
            // --------------------------------------------------
            if (current[1] < next[0]) {

                // Current interval is complete
                result.add(current);

                // Start a new interval
                current = next;

            }
            else {

                // ------------------------------------------------
                // Overlap
                //
                // Merge current and next.
                // ------------------------------------------------
                current[1] =
                        Math.max(current[1], next[1]);
            }
        }


        // Add the final merged interval
        result.add(current);


        return result.toArray(new int[result.size()][]);
    }
}