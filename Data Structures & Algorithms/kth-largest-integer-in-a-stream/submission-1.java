class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k=0;

    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>(k);
        this.k=k;
        for(int i=0;i<nums.length;i++){
            int elem=nums[i];
            if(pq.size()<k){
                pq.offer(elem);
            }else{
             int top=pq.peek();
            if(top<elem){
                pq.poll();
                pq.offer(elem);

            }
            }

        }
        System.out.println("pq:"+pq);
    }
    
    public int add(int val) {



            if(pq.size()<k){
                pq.offer(val);
            }else{
             int top=pq.peek();
            if(top<val){
                pq.poll();
                pq.offer(val);

            }
            }
            return pq.peek();
        
    }
}
