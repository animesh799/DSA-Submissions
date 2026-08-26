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
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> arrival=new ArrayList<>();
        List<Integer> departure=new ArrayList<>();

        int n=intervals.size();
        for(int i=0;i<n;i++){
            Interval interval=intervals.get(i);
            arrival.add(interval.start);
            departure.add(interval.end);
        }

        arrival.sort((a,b)->a-b);
        departure.sort((a,b)->a-b);

        int res=0;
        int p1=0,p2=0;
        int rooms=0;

        while(p1<n){
          if(arrival.get(p1)<departure.get(p2)){
            res++;
            p1++;
          }else if(arrival.get(p1)>departure.get(p2)){
            res--;
            p2++;
          }else{
            p1++;
            p2++;
          }

          rooms=Math.max(rooms,res);
        }

        return rooms;

    }
}
