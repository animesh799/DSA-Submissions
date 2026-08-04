class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;


        int prefix=1,postfix=1;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(postfix==0) postfix=1;

            prefix=prefix*nums[i];
            postfix=postfix*nums[n-i-1];
            max=Math.max(prefix,max);
            max=Math.max(postfix,max);

        }

        return max;
    }
}
