class Solution {

    public int rob(int[] nums) {

        // dp[i] stores:
        // Maximum money that can be robbed
        // starting from house i till the end.
        int[] dp = new int[nums.length];

        // Start making decisions from house 0.
        return maxRob(0, nums, dp);
    }

    private int maxRob(int idx, int[] nums, int[] dp) {

        // ---------------- Base Case ----------------

        // No houses left to rob.
        if (idx >= nums.length) {
            return 0;
        }

        // If we've already solved this subproblem,
        // return the stored answer.
        if (dp[idx] != 0) {
            return dp[idx];
        }

        // ---------------- Choices ----------------

        // Choice 1:
        // Rob the current house.
        //
        // Since adjacent houses cannot be robbed,
        // move to idx + 2.
        int take = nums[idx] + maxRob(idx + 2, nums, dp);

        // Choice 2:
        // Skip the current house
        // and move to the next one.
        int skip = maxRob(idx + 1, nums, dp);

        // Store the best possible answer starting
        // from the current house.
        dp[idx] = Math.max(take, skip);

        return dp[idx];
    }
}






// class Solution {

//     public int rob(int[] nums) {

//         int next = 0;      // dp[i+1]
//         int nextNext = 0;  // dp[i+2]

//         // Compute from right to left.
//         for (int i = nums.length - 1; i >= 0; i--) {

//             int curr = Math.max(
//                     nums[i] + nextNext,
//                     next
//             );

//             nextNext = next;
//             next = curr;
//         }

//         return next;
//     }
// }