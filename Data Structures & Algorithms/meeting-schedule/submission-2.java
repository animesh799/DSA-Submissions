class Solution {

    public boolean canAttendMeetings(List<Interval> intervals) {

        // Sort meetings by their start time.
        intervals.sort((a, b) -> a.start - b.start);

        int len = intervals.size();

        // No meetings → obviously can attend all.
        if (len == 0) {
            return true;
        }

        // Keep track of the previous meeting.
        Interval prev = intervals.get(0);

        for (int i = 1; i < len; i++) {

            Interval curr = intervals.get(i);

            // If current meeting starts before the
            // previous meeting ends, they overlap.
            if (curr.start < prev.end) {
                return false;
            }

            // Current meeting becomes previous meeting
            // for the next iteration.
            prev = curr;
        }

        return true;
    }
}