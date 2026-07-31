class Solution {

    // Stores all the generated permutations
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        // visited[i] tells whether nums[i] is already used
        // in the current permutation.
        boolean[] visited = new boolean[nums.length];

        // Start backtracking with an empty permutation.
        backtrack(nums, visited, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> current) {

        // ===========================
        // Base Case
        // ===========================
        // If the current permutation contains all elements,
        // we've formed one valid answer.
        if (current.size() == nums.length) {

            // Always create a new copy before storing.
            // Otherwise, all answers will point to the same list.
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every element as the next choice.
        for (int i = 0; i < nums.length; i++) {

            // Skip if this element is already used
            // in the current permutation.
            if (visited[i])
                continue;

            // ===========================
            // CHOOSE
            // ===========================
            // Mark the element as used.
            visited[i] = true;

            // Add it to the current permutation.
            current.add(nums[i]);

            // ===========================
            // EXPLORE
            // ===========================
            // Recursively build the remaining permutation.
            backtrack(nums, visited, current);

            // ===========================
            // UNCHOOSE (Backtrack)
            // ===========================
            // Undo the changes so that the next iteration
            // starts from the previous state.

            // Remove the last inserted element.
            current.remove(current.size() - 1);

            // Mark it as unused so it can be used
            // in another permutation.
            visited[i] = false;
        }
    }
}