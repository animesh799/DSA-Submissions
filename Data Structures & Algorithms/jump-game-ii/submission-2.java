class Solution {

    public int jump(int[] nums) {

        int n = nums.length;

        // If there is only one element,
        // we are already at the destination.
        if (n == 1) {
            return 0;
        }

        /*
         * [left ... right] represents the range of indices
         * that can be reached using the current number of jumps.
         *
         * Initially:
         * left = 0
         * right = 0
         *
         * So with 0 jumps, we are only at index 0.
         */
        int left = 0;
        int right = 0;

        // Number of jumps taken.
        int jump = 0;

        /*
         * Continue until our current reachable range
         * contains the last index.
         */
        while (right < n - 1) {

            // Farthest index we can reach with ONE more jump
            // from any index in the current range.
            int farthest = 0;

            /*
             * Check every index in the current reachable range.
             *
             * We don't choose just one index.
             * We find which index gives us the maximum reach.
             */
            for (int i = left; i <= right; i++) {

                // From index i, we can reach:
                // i + nums[i]
                farthest = Math.max(farthest, i + nums[i]);
            }

            /*
             * The next range starts immediately after
             * the current range.
             *
             * Example:
             *
             * Current range = [0 ... 2]
             * Next range starts from index 3.
             */
            left = right + 1;

            /*
             * The farthest index becomes the end
             * of our next reachable range.
             */
            right = farthest;

            // We used one jump to move to this new range.
            jump++;
        }

        return jump;
    }
}