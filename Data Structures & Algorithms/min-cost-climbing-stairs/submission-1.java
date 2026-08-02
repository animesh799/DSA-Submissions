class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;

        if(len==2) return Math.min(cost[0],cost[1]);
        int prev1=cost[0];
        int prev2=cost[1];

        for(int i=2;i<len;i++){
            int min=Math.min(prev1,prev2);
            int currCost=cost[i]+min;

            prev1=prev2;
            prev2=currCost;


            
        }
        return Math.min(prev1,prev2);
        
    }
}
