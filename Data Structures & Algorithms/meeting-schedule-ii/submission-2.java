class Solution {

    public int minMeetingRooms(List<Interval> intervals) {

        List<Integer> arrival = new ArrayList<>();
        List<Integer> departure = new ArrayList<>();

        // Store all start and end times separately
        for (Interval interval : intervals) {
            arrival.add(interval.start);
            departure.add(interval.end);
        }

        // Sort start times and end times independently
        arrival.sort((a, b) -> Integer.compare(a, b));
        departure.sort((a, b) -> Integer.compare(a, b));


        int p1 = 0; // points to next meeting starting
        int p2 = 0; // points to next meeting ending

        int rooms = 0;
        int maxRooms = 0;


        while (p1 < arrival.size()) {

            // A meeting starts before the earliest
            // currently tracked meeting ends.
            //
            // Need a new room.
            if (arrival.get(p1) < departure.get(p2)) {

                rooms++;
                p1++;

            }
            else {

                // A meeting has ended before/equal to
                // the next meeting's start.
                //
                // Reuse that room.
                rooms--;
                p2++;
            }

            maxRooms = Math.max(maxRooms, rooms);
        }


        return maxRooms;
    }
}