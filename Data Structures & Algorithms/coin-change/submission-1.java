class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        int count=minWays(amount,coins,dp);
        if(count==Integer.MAX_VALUE-1) return -1;
        return count;
        
    }


    private int minWays(int amount,int[] coins,int[] dp){
        if(amount==0){
            return 0;
        }

        if(dp[amount]!=0) return dp[amount];

        int min=Integer.MAX_VALUE-1;
        for(int i=0;i<coins.length;i++){

            if((amount-coins[i])>=0){
                int ans=minWays(amount-coins[i],coins,dp);
                if(ans!=Integer.MAX_VALUE-1){
                   min=Math.min(min,ans+1);
                }
               
            }
        }
        return dp[amount]=min;
    }
}
