class Solution {

    public int numDecodings(String s) {

        // dp[i] stores:
        // Number of ways to decode the substring
        // starting from index i.
        int[] dp = new int[s.length()];

        // -1 means this state
        // has not been computed yet.
        Arrays.fill(dp, -1);

        // Start decoding from index 0.
        return decode(0, s, dp);
    }

    private int decode(int idx, String s, int[] dp) {

        // ---------------- Base Cases ----------------

        // Successfully decoded the entire string.
        //
        // Example:
        // "226"
        //      ^
        //
        // We found one valid decoding.
        if (idx == s.length()) {
            return 1;
        }

        // A code cannot start with '0'.
        //
        // Example:
        // "06"
        //  ^
        //
        // There is no mapping for 0.
        if (s.charAt(idx) == '0') {
            return 0;
        }

        // If we've already solved this subproblem,
        // return the stored answer.
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // ---------------- Choices ----------------

        // Choice 1:
        // Decode only one digit.
        //
        // Example:
        // "226"
        //  ^
        //
        // Take '2' and continue from index + 1.
        int ways = decode(idx + 1, s, dp);

        // Choice 2:
        // Decode two digits together.
        //
        // Example:
        // "226"
        //  ^^
        //
        // Take "22" only if it is between
        // 10 and 26.
        if (idx + 1 < s.length()) {

            int num = (s.charAt(idx) - '0') * 10
                    + (s.charAt(idx + 1) - '0');

            if (num >= 10 && num <= 26) {
                ways += decode(idx + 2, s, dp);
            }
        }

        // Store and return the answer
        // for this index.
        return dp[idx] = ways;
    }
}