class Solution {

    public boolean canJump(int[] nums) {

        int n = nums.length;

        // If there is only one element,
        // we are already standing at the last index.
        if (n == 1) {
            return true;
        }

        // Farthest index that we can currently reach.
        int maxJump = 0;

        for (int i = 0; i < n; i++) {

            /*
             * If the current index is beyond our maximum reach,
             * then we cannot even reach this index.
             * Therefore, reaching the last index is impossible.
             */
            if (maxJump < i) {
                return false;
            }

            /*
             * From index i, we can jump up to:
             *
             * i + nums[i]
             *
             * Update our overall farthest reachable index.
             */
            int currRange = i + nums[i];

            maxJump = Math.max(maxJump, currRange);

            /*
             * If our reachable range already includes
             * the last index, we are done.
             */
            if (maxJump >= n - 1) {
                return true;
            }
        }

        return false;
    }
}