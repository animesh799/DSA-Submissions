class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int len = intervals.length;

        List<int[]> list = new ArrayList<>();

        int i = 0;


        // ---------------------------------------------------------
        // 1. Intervals completely BEFORE newInterval
        // ---------------------------------------------------------
        while (i < len &&
               intervals[i][1] < newInterval[0]) {

            list.add(intervals[i]);
            i++;
        }


        // ---------------------------------------------------------
        // 2. Intervals OVERLAPPING newInterval
        // ---------------------------------------------------------
        while (i < len &&
               intervals[i][0] <= newInterval[1]) {

            newInterval[0] =
                    Math.min(newInterval[0], intervals[i][0]);

            newInterval[1] =
                    Math.max(newInterval[1], intervals[i][1]);

            i++;
        }


        // Add the merged/new interval
        list.add(newInterval);


        // ---------------------------------------------------------
        // 3. Intervals completely AFTER newInterval
        // ---------------------------------------------------------
        while (i < len) {

            list.add(intervals[i]);
            i++;
        }


        // Convert List<int[]> -> int[][]
        return list.toArray(new int[list.size()][]);
    }
}