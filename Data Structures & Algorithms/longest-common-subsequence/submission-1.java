class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        // dp[p1][p2] stores the LCS length of:
        // text1[p1 ... end] and text2[p2 ... end]
        int[][] dp = new int[m][n];

        // Java initializes int arrays with 0.
        // But 0 is a valid LCS answer, so we use -1
        // to indicate that a state has not been calculated yet.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return lcs(text1, text2, 0, 0, dp);
    }

    private int lcs(
        String s1,
        String s2,
        int p1,
        int p2,
        int[][] dp
    ) {

        // If either string is completely processed,
        // there can be no more common characters.
        if (p1 == s1.length() || p2 == s2.length()) {
            return 0;
        }

        // If this state was already calculated,
        // return the stored result.
        if (dp[p1][p2] != -1) {
            return dp[p1][p2];
        }

        char ch1 = s1.charAt(p1);
        char ch2 = s2.charAt(p2);

        // Case 1: Current characters match.
        // Include this character in the LCS and move
        // both pointers forward.
        if (ch1 == ch2) {

            dp[p1][p2] =
                1 + lcs(s1, s2, p1 + 1, p2 + 1, dp);

        } else {

            // Case 2: Characters don't match.
            // We have two choices:
            //
            // 1. Skip current character of s1
            // 2. Skip current character of s2
            //
            // Take the better of the two choices.
            dp[p1][p2] = Math.max(
                lcs(s1, s2, p1 + 1, p2, dp),
                lcs(s1, s2, p1, p2 + 1, dp)
            );
        }

        return dp[p1][p2];
    }
}