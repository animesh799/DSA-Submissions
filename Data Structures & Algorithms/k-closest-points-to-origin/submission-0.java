class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq=new PriorityQueue<>(k,(a,b)->Double.compare(findDistance(b[0],b[1]),findDistance(a[0],a[1])));

        int len=points.length;

        for(int i=0;i<len;i++){
            int[] point=points[i];
            if(k>pq.size()){
                pq.offer(point);
            }else{
                int[] peek=pq.peek();
                double dist1=findDistance(peek[0],peek[1]);
                double dist2=findDistance(point[0],point[1]);
                if(dist1>dist2){
                    pq.poll();
                    pq.offer(point);
                }
            }
        }
        int[][] res=new int[k][2];

        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }

        return res;


        

    }

    private double findDistance(int x,int y){

       double distance= Math.sqrt(x*x+y*y);
       return distance;
    }
}
