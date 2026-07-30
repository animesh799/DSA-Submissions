class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=0;
        for(int i=0;i<piles.length;i++){
        max=Math.max(max,piles[i]);
        }
        int ans=Integer.MAX_VALUE-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            boolean flag=checkPossible(piles,mid,h);
            if(flag){
                ans=mid;
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return ans;
    }

    private boolean checkPossible(int[] piles,int mid, int h){
        int count=0;
        for(int i=0;i<piles.length;i++){
            count=count+(int)Math.ceil((piles[i]*1d)/(mid*1d));
        }
        if(count>h){
            return false;
        }
        return true;
    }
}
