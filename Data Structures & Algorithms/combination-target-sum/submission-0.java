class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {

      
        findCombination(0,nums,target,new ArrayList<>());
        return result;
        
    }

    private void findCombination(int i,int[] nums,int target,List<Integer> set){
        if(i==nums.length||target<0) return;

        if(target==0){
           List<Integer> list=new ArrayList<>();
           list.addAll(set);
           result.add(list);
           return;
        }
        
        set.add(nums[i]);
        findCombination(i,nums,target-nums[i],set);
        set.remove(set.size()-1);
        findCombination(i+1,nums,target,set);
    }
}
