class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int len=intervals.length;

        if(len==1) return intervals;

        List<int[]> list=new ArrayList<>();
        int prev[]=null;
        int curr[]=null;
        for(int i=1;i<len;i++){
            prev=intervals[i-1];
            curr=intervals[i];

            if(prev[1]<curr[0]){
                list.add(prev);
            }else{
                curr[0]=Math.min(prev[0],curr[0]);
                curr[1]=Math.max(prev[1],curr[1]);
            }
        }
        list.add(curr);

        int[][] res=new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }

        return res;

        
    }
}
