class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        

        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0) return false;

        sum=sum/2;
        Boolean dp[][]=new Boolean[n][sum+1];

        return find(0,sum,nums,dp);
        
    }

    public boolean find(int idx,int target,int[] nums,Boolean[][] dp){
        if(idx==nums.length){
            return false;
        }

        if(target==0) return true;
        if(dp[idx][target]!=null) return dp[idx][target];

        boolean skip=find(idx+1,target,nums,dp);

        boolean take=false;

        if(nums[idx]<=target){
          take=find(idx+1,target-nums[idx],nums,dp);
        }

        return dp[idx][target]=skip||take;

        
    }
}
