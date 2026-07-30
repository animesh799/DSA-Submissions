class Solution {

    // Stores all subsets
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        // Start from index 0 with an empty subset
        computeSubsets(nums, 0, new ArrayList<>());

        return result;
    }

    private void computeSubsets(int[] nums, int itr, List<Integer> set) {

        // Base Case:
        // We've considered every element.
        // Store the current subset.
        if (itr == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }

        // -------------------------
        // Choice 1 : Include current element
        // -------------------------
        set.add(nums[itr]);
        computeSubsets(nums, itr + 1, set);

        // Backtrack
        // Remove the element so we can explore
        // the "exclude" branch.
        set.remove(set.size() - 1);

        // -------------------------
        // Choice 2 : Exclude current element
        // -------------------------
        computeSubsets(nums, itr + 1, set);
    }
}