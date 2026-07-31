class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        calculatePermutation(0,nums,new LinkedHashSet<Integer>());
        return result;
    }

    private void calculatePermutation(int itr,int[] nums,Set<Integer> set){
      if(itr==nums.length){
        result.add(new ArrayList<>(set));
        return;
      }

      for(int i=0;i<nums.length;i++){
        if(!set.contains(nums[i])){
            set.add(nums[i]);
            calculatePermutation(itr+1,nums,set);
            set.remove(nums[i]);
        }
      }

    }
}
