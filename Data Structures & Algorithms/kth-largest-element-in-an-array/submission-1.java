class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>(k,(a,b)->a-b);

        for(int i=0;i<nums.length;i++){
            if(pq.size()<k){
                pq.offer(nums[i]);
            }else{
           //     System.out.println(pq);
                int peek=pq.peek();
                if(peek<nums[i]){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }

        return pq.peek();
        
    }
}
