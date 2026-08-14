class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;

        int maxJump=0;

        for(int i=0;i<n;i++){
            if(maxJump<i) return false;
            int currRange=i+nums[i];
            maxJump=Math.max(maxJump,currRange);
            if(maxJump>=n-1) return true;
        }

        return false;
        
    }
}
