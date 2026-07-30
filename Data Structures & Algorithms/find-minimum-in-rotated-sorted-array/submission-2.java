class Solution {
    public int findMin(int[] nums) {
        int start=0,end=nums.length-1;
        int ans=Integer.MAX_VALUE-1;
        while(start<end){
          int mid=start+(end-start)/2;

          int elem=nums[mid];

          if(nums[end]>elem){
              end=mid;
          }else{
            start=mid+1;
          }
        }
        return nums[end];
    }
}
