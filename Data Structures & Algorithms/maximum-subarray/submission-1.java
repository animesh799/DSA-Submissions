class Solution {

    public int maxSubArray(int[] nums) {

        // Stores the sum of the current subarray
        int sum = 0;

        // Stores the maximum subarray sum found so far.
        // Use Integer.MIN_VALUE because all elements can be negative.
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // Add the current element to our current subarray.
            sum += nums[i];

            // Update the overall maximum.
            max = Math.max(max, sum);

            /*
             * If the current sum becomes negative,
             * carrying it forward will only hurt any
             * future subarray.
             *
             * So, discard the current subarray and
             * start a new one from the next element.
             */
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}