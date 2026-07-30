class Solution {

    // Stores all valid combinations
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        // Start from index 0
        findCombination(0, nums, target, new ArrayList<>());

        return result;
    }

    private void findCombination(int i, int[] nums, int target, List<Integer> set) {

        // If target becomes exactly 0,
        // current combination is valid.
        if (target == 0) {
            result.add(new ArrayList<>(set));
            return;
        }

        // No candidates left OR target exceeded.
        if (i == nums.length || target < 0)
            return;

        // ----------------------------
        // Choice 1 : Take current number
        // Don't move index because
        // same number can be reused.
        // ----------------------------
        set.add(nums[i]);
        findCombination(i, nums, target - nums[i], set);

        // Backtrack
        set.remove(set.size() - 1);

        // ----------------------------
        // Choice 2 : Skip current number
        // Move to next candidate.
        // ----------------------------
        findCombination(i + 1, nums, target, set);
    }
}