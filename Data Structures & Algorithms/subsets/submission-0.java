class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        
        computeSubsets(nums,0,new ArrayList<>());

        return result;
        
    }

    private void computeSubsets(int[] nums,int itr,List<Integer> set){
        if(itr==nums.length){
            List<Integer> list=new ArrayList<>();
            list.addAll(set);
            result.add(list);
         return;
        }
        set.add(nums[itr]);
        computeSubsets(nums,itr+1,set);
        set.remove(set.size()-1);
        computeSubsets(nums,itr+1,set);
    }
}
