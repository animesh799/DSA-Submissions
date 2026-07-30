class Solution {
    public int findDuplicate(int[] nums) {
        
    //  for(int i=0;i<nums.length;i++){
    //     int index=nums[i];
    //     if(nums[Math.abs(index)]<0){
    //         for(int j=0;j<nums.length;j++){
    //           nums[j]=Math.abs(nums[j]);
    //         }
    //         return Math.abs(index);
    //     }else{
    //         nums[Math.abs(index)]=-1*nums[Math.abs(index)];
    //     }
    //  }
    //  return -1;
    // }

    int slow=nums[0];
    int fast=nums[0];

    do{
        slow=nums[slow];
        fast=nums[nums[fast]];
    }while(slow!=fast);

    slow=nums[0];

    while(slow!=fast){
        slow=nums[slow];
        fast=nums[fast];
    }
    
    return slow;

}
}