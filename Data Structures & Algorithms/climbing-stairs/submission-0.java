class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n];
        return ways(0,n,dp);
        
    }

    private int ways(int i,int n,int dp[]){
        System.out.println("enter");
        if(i==n) return 1;
        if(i>n) return 0;

        if(dp[i]!=0) return dp[i];

        int sum=ways(i+1,n,dp);
        sum=sum+ways(i+2,n,dp);
        return dp[i]=sum;
    }
}
