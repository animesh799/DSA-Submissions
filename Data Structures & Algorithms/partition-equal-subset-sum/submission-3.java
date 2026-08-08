class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums)
            sum += num;

        if(sum % 2 != 0)
            return false;

        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return canMake(nums, 0, target, dp);
    }

    private boolean canMake(int[] nums, int idx, int target, Boolean[][] dp) {

        // We found a subset with the required sum.
        if (target == 0)
            return true;

        // No elements left but target is still not 0.
        if (idx == nums.length)
            return false;

        // Return the cached answer if we've solved this state before.
        if (dp[idx][target] != null)
            return dp[idx][target];

        // Option 1: Skip the current element.
        boolean skip = canMake(nums, idx + 1, target, dp);

        // Option 2: Take the current element (only if it doesn't exceed target).
        boolean take = false;
        if (nums[idx] <= target) {
            take = canMake(nums, idx + 1, target - nums[idx], dp);
        }

        // Store and return the result.
        return dp[idx][target] = take || skip;
    }
}