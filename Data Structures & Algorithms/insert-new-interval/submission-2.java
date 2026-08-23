class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int len=intervals.length;
        List<int[]> list=new ArrayList<>();

        for(int i=0;i<len;i++){


            //left most part

            while(i<len&&intervals[i][1]<newInterval[0]){
                list.add(intervals[i]);
                i++;
            }

            //middle part
            while(i<len&&intervals[i][0]<=newInterval[1]){
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
                i++;
            }
            list.add(newInterval);

            while(i<len){
                list.add(intervals[i]);
                i++;
            }
        }
           if(list.isEmpty()){
            list.add(newInterval);
           }

            int res[][]=new int[list.size()][2];

            for(int i=0;i<list.size();i++){
                res[i]=list.get(i);
            }



            return res;
        
    }

}
