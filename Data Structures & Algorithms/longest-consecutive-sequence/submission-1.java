class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=0;

        for(int num:set){
            if(!set.contains(num-1)){
                int count=1;
                int next=num+1;
                while(set.contains(next)){
                    count++;
                    next++;
                }
                max=Math.max(max,count);
               
            }
        }
        
        return max;
    }
}
