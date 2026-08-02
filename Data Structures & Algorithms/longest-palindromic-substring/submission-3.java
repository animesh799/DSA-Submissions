class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        // dp[i][j] stores:
        // Is the substring s[i...j] a palindrome?
        boolean[][] dp = new boolean[n][n];

        // ---------------- Base Case ----------------
        // Every single character is a palindrome.
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Stores the longest palindrome found so far.
        int max = 1;
        int maxStart = 0;

        // ------------------------------------------------
        // Process substrings from length = 2 to n.
        //
        // We process smaller substrings first because
        // dp[start][end] depends on dp[start+1][end-1].
        // ------------------------------------------------
        for (int len = 2; len <= n; len++) {

            // Generate every substring of current length.
            //
            // Last possible starting index is (n-len).
            for (int start = 0; start <= n - len; start++) {

                int end = start + len - 1;

                // First and last characters must match.
                if (s.charAt(start) != s.charAt(end)) {
                    continue;
                }

                // ---------------- Base Case ----------------
                // Length = 2
                //
                // Example:
                // "aa"
                // "bb"
                //
                // Since both characters already match,
                // the substring is a palindrome.
                if (len == 2) {

                    dp[start][end] = true;

                } else {

                    // ---------------- Recurrence ----------------
                    //
                    // Example:
                    //
                    // "abcba"
                    //
                    // First == Last ?
                    //
                    // YES
                    //
                    // Then the middle substring
                    // "bcb"
                    // must also be a palindrome.
                    //
                    // Therefore:
                    //
                    // dp[start][end]
                    // =
                    // dp[start+1][end-1]
                    //
                    dp[start][end] = dp[start + 1][end - 1];
                }

                // Update the longest palindrome found.
                if (dp[start][end] && len > max) {

                    max = len;
                    maxStart = start;
                }
            }
        }

        // Return the longest palindromic substring.
        return s.substring(maxStart, maxStart + max);
    }
}