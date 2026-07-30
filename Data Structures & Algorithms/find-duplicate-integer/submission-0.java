class Solution {
    public int findDuplicate(int[] nums) {
        
     for(int i=0;i<nums.length;i++){
        int index=nums[i];
        if(nums[Math.abs(index)]<0){
            for(int j=0;j<nums.length;j++){
              nums[j]=Math.abs(nums[j]);
            }
            return Math.abs(index);
        }else{
            nums[Math.abs(index)]=-1*nums[Math.abs(index)];
        }
     }
     return -1;
    }
}
