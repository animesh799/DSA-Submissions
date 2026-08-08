class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        int dp[]=new int[n];

        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        
        for(int i=0;i<n;i++){
            int curr=nums[i];
            int j=i-1;
            while(j>=0){
              int prev=nums[j];
              if(prev<curr){
                dp[i]=Math.max(dp[i],dp[j]+1);
              }
               j--;
            }
        }

        int max=1;

        for(int i=0;i<n;i++){
          max=Math.max(max,dp[i]);
        }
        return max;
    }
}
