class Solution {
    public int findMin(int[] nums) {
        int start=0,end=nums.length-1;
        int ans=Integer.MAX_VALUE-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            boolean check=isLeftSide(mid,nums);
            if(check){
                ans=Math.min(ans,nums[mid]);
              if(nums[end]<nums[mid]){
                 start=mid+1;
              }else{
                end=mid-1;
              }
            }else{
              ans=Math.min(ans,nums[mid]);
              end=mid-1;

            }
        }
        return ans;
    }

    private boolean isLeftSide(int mid,int[] nums){
        if(nums[0]<=nums[mid]){
            return true;
        }
        return false;
    }
}
