class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq=new ArrayDeque<>();

        int l=nums.length;
        int[] res=new int[l-k+1];


        for(int i=0;i<l;i++){


            while(!dq.isEmpty()&&dq.peekFirst()<(i-(k-1))){
                dq.pollFirst();
             }
             
             while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
             }
             dq.offerLast(i);

             if(i>=k-1){
              res[i-k+1]=nums[dq.peekFirst()];
             }

        }

        return res;
        
    }
}
