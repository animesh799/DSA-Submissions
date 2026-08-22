/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort((a,b)->a.start-b.start);

        int len=intervals.size();
        if(len==0) return true;

        Interval prev=intervals.get(0);
        Interval curr;

        for(int i=1;i<len;i++){
            curr=intervals.get(i);
            if(curr.start<prev.end) return false;
            prev=curr;
        }

        return true;

    }
}
