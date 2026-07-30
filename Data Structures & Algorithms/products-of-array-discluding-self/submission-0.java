class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        long[] prefix=new long[len];
        long[] postfix=new long[len];
        int pre=1,post=1;
        for(int i=0;i<len;i++){
        pre=pre*nums[i];
        post=post*nums[len-1-i];
        prefix[i]=pre;
        postfix[len-1-i]=post;
        }

        int ans[]=new int[len];
        for(int i=0;i<len;i++){
            pre=1;
            post=1;
            if(i>0){
                pre=(int)prefix[i-1];
            }
            if(i<len-1){
                post=(int)postfix[i+1];
            }
            ans[i]=pre*post;

        }

        return ans;
        
    }
}  
