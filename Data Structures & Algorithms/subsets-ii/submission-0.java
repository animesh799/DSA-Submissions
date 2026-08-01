class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res=new ArrayList<>();
        Arrays.sort(nums);
        subsets(0,nums,new ArrayList<>());
        return res;
    }

private void subsets(int start,int[] nums,List<Integer> set){

    res.add(new ArrayList<>(set));

    for(int i=start;i<nums.length;i++){

        if(i>start && nums[i]==nums[i-1])
            continue;

        set.add(nums[i]);

        subsets(i+1,nums,set);

        set.remove(set.size()-1);
    }
}
}
