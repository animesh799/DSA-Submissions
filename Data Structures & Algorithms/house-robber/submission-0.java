class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        return maxRob(0,nums,dp);
        
    }

    private int maxRob(int idx,int[] nums,int dp[]){
        if(idx>=nums.length) return 0;

        if(dp[idx]!=0) return dp[idx];

        int max=0;

        //take It or leave it
        max=Math.max(nums[idx]+maxRob(idx+2,nums,dp),maxRob(idx+1,nums,dp));
        dp[idx]=max;
        return max;

    }
}
