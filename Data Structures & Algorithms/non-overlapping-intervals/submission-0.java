class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int len=intervals.length;
        if(len==1) return 0;
        int res=0;
        int[] prev=intervals[0];
        for(int i=1;i<len;i++){
            int curr[]=intervals[i];
            if(prev[1]>curr[0]){
                res++;
            }else{
                prev=curr;
            }

        }

        return res;
        
    }
}
