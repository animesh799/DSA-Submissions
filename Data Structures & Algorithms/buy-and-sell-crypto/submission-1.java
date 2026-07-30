class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length-1,profit=0;
        if(len==0) return 0;
        int sp=prices[len];

        for(int i=len-1;i>=0;i--){
            System.out.println("Sp :"+sp);
            int currPrice=prices[i];
            profit=Math.max(profit,sp-currPrice);
            if(currPrice>sp){
                sp=currPrice;
            }
        }
        return profit;
    }
}
