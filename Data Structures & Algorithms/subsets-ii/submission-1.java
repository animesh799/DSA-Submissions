class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sorting is necessary so that duplicate numbers become adjacent.
        // This allows us to skip duplicate branches easily.
        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<>());

        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> subset) {

        // Every recursive state represents a valid subset.
        // So, store the current subset before exploring further.
        res.add(new ArrayList<>(subset));

        // Try choosing every element from the current position onwards.
        for (int i = start; i < nums.length; i++) {

            // Skip duplicate elements at the SAME recursion level.
            //
            // Example:
            // nums = [1,2,2]
            //
            // At the root level:
            // Pick first 2  -> valid
            // Pick second 2 -> skipped (would generate duplicate subsets)
            //
            // We only skip when i > start because duplicates are allowed
            // in different recursion levels.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose the current element.
            subset.add(nums[i]);

            // Explore subsets including this element.
            backtrack(i + 1, nums, subset);

            // Backtrack: remove the last chosen element so that
            // the next iteration starts with a clean state.
            subset.remove(subset.size() - 1);
        }
    }
}