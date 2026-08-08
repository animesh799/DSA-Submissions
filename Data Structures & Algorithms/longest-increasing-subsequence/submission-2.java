class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // dp[i] = Length of the Longest Increasing Subsequence
        // ending exactly at index i.
        int[] dp = new int[n];

        // Every single element by itself is an LIS of length 1.
        Arrays.fill(dp, 1);

        // Stores the overall longest increasing subsequence found so far.
        int ans = 1;

        // Consider every element as the ending element of an LIS.
        for (int i = 0; i < n; i++) {

            // Check all elements before the current element.
            for (int j = 0; j < i; j++) {

                // If nums[j] is smaller than nums[i],
                // then nums[i] can extend the LIS ending at j.
                if (nums[j] < nums[i]) {

                    // Take the best possible LIS ending at i.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update the overall answer.
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}