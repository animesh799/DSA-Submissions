class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        if(l==1){
            return nums[0];
        }

        return Math.max(robMax(nums,1,l-1),robMax(nums,0,l-2));
        
    }

    private int robMax(int[] nums,int start,int end){


        int next1=0,next2=0;

        for(int i=end;i>=start;i--){

            int currMax=Math.max(nums[i]+next2,next1);

            next2=next1;
            next1=currMax;
        }

        return next1;




    }
}
