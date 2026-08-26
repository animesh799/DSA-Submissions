class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n=queries.length;
        int[][] sortedQuery=new int[n][2];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for(int i=0;i<n;i++){
            sortedQuery[i][0]=queries[i];
            sortedQuery[i][1]=i;
        }
        
        Arrays.sort(sortedQuery,(a,b)->a[0]-b[0]);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]-a[0])-(b[1]-b[0]));

        int p1=0,len=intervals.length;

        int[] res=new int[queries.length];

        for(int i=0;i<queries.length;i++){

            while(p1<len&&intervals[p1][0]<=sortedQuery[i][0]){
       //         System.out.println("interval:"+intervals[p1][0]);
                pq.offer(intervals[p1]);
                p1++;
            }

            


            int[] peek=pq.peek();

       //     System.out.println("peek :"+peek[0]+" "+peek[1]);

            while(!pq.isEmpty()&&peek[1]<sortedQuery[i][0]){
                pq.poll();
                peek=pq.peek();
            }
            if(peek==null){
              res[sortedQuery[i][1]]=-1;
            }else{
              res[sortedQuery[i][1]]=peek[1]-peek[0]+1;
            }
            

        }  

        return res;   
    }
}
