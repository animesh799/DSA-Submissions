class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int len=stones.length;
        for(int i=0;i<len;i++){
            pq.offer(stones[i]);
        }
        if(pq.size()==1) return pq.poll();

        while(!pq.isEmpty()){
            int stone1=pq.poll();
            int stone2=pq.poll();
            int diff=Math.abs(stone1-stone2);
            if(pq.isEmpty()) return diff;
            pq.offer(diff);
        }

        return 0;

        
    }
}
