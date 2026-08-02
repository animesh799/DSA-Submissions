class Solution {

    public int climbStairs(int n) {

        // If there is only 1 stair,
        // there is only 1 way to reach it.
        //
        // If there are 2 stairs,
        // there are 2 ways:
        // (1+1) or (2)
        if (n <= 2) {
            return n;
        }

        // prev2 = ways to reach stair (i-2)
        // prev1 = ways to reach stair (i-1)
        int prev2 = 1;
        int prev1 = 2;

        // Calculate ways from stair 3 to stair n.
        for (int i = 3; i <= n; i++) {

            // To reach the current stair,
            // we can come from:
            // 1. Previous stair (i-1)
            // 2. Two stairs before (i-2)
            //
            // Hence:
            // ways(i) = ways(i-1) + ways(i-2)
            int curr = prev1 + prev2;

            // Shift the window forward.
            prev2 = prev1;
            prev1 = curr;
        }

        // prev1 now stores the answer for stair n.
        return prev1;
    }
}