class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // Edge Case:
        // If there is only one house,
        // we have no choice but to rob it.
        if (n == 1) {
            return nums[0];
        }

        // Since the first and last houses are adjacent,
        // they cannot both be robbed.
        //
        // So we solve two separate House Robber I problems:
        //
        // Case 1:
        // Ignore the first house.
        //
        // Case 2:
        // Ignore the last house.
        //
        // The answer is the maximum of these two cases.
        return Math.max(
                robMax(nums, 1, n - 1),
                robMax(nums, 0, n - 2)
        );
    }

    private int robMax(int[] nums, int start, int end) {

        // DP State:
        //
        // next1 = Maximum money that can be robbed
        //         starting from house (i + 1).
        //
        // next2 = Maximum money that can be robbed
        //         starting from house (i + 2).
        //
        // We don't need a DP array because
        // dp[i] depends only on dp[i+1] and dp[i+2].
        int next1 = 0;
        int next2 = 0;

        // Process houses from right to left
        // so that dp[i+1] and dp[i+2]
        // are already available.
        for (int i = end; i >= start; i--) {

            // Choice 1:
            // Rob the current house.
            //
            // Since adjacent houses cannot be robbed,
            // move to house (i + 2).
            int take = nums[i] + next2;

            // Choice 2:
            // Skip the current house.
            int skip = next1;

            // Best possible money starting from house i.
            int currMax = Math.max(take, skip);

            // Shift the DP window.
            //
            // Before:
            // next2 -> dp[i+2]
            // next1 -> dp[i+1]
            //
            // After:
            // next2 -> dp[i+1]
            // next1 -> dp[i]
            next2 = next1;
            next1 = currMax;
        }

        // next1 now stores the answer
        // for the starting house.
        return next1;
    }
}