class Solution {

    public int countSubstrings(String s) {

        int n = s.length();

        // dp[i][j] stores:
        // Is substring s[i...j] a palindrome?
        boolean[][] dp = new boolean[n][n];

        // Every single character is a palindrome.
        int count = n;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Process substrings from length = 2 to n.
        //
        // We process smaller substrings first because
        // dp[start][end] depends on dp[start+1][end-1].
        for (int len = 2; len <= n; len++) {

            // Generate all substrings of current length.
            for (int start = 0; start <= n - len; start++) {

                int end = start + len - 1;

                // First and last characters must match.
                if (s.charAt(start) != s.charAt(end)) {
                    continue;
                }

                // Length = 2
                //
                // Example:
                // "aa"
                //
                // Since both characters already match,
                // it is a palindrome.
                if (len == 2) {
                    dp[start][end] = true;
                }

                // Length > 2
                //
                // Example:
                // "abcba"
                //
                // First == Last ?
                //
                // YES
                //
                // Then middle substring
                // "bcb"
                // must also be a palindrome.
                else {
                    dp[start][end] = dp[start + 1][end - 1];
                }

                // Found one more palindrome.
                if (dp[start][end]) {
                    count++;
                }
            }
        }

        return count;
    }
}









// class Solution {

//     public int countSubstrings(String s) {

//         int count = 0;

//         // Every index can act as the center
//         // of an odd-length palindrome.
//         //
//         // Every gap between two characters
//         // can act as the center of an
//         // even-length palindrome.
//         for (int i = 0; i < s.length(); i++) {

//             // Odd length palindrome.
//             //
//             // Example:
//             // "aba"
//             //   ^
//             count += expand(s, i, i);

//             // Even length palindrome.
//             //
//             // Example:
//             // "abba"
//             //    ^
//             count += expand(s, i, i + 1);
//         }

//         return count;
//     }

//     // Expands around the given center
//     // and counts all palindromes.
//     private int expand(String s, int left, int right) {

//         int count = 0;

//         // Expand while
//         // 1. Indices are inside the string.
//         // 2. Characters match.
//         while (left >= 0 &&
//                right < s.length() &&
//                s.charAt(left) == s.charAt(right)) {

//             // Every successful expansion
//             // forms one palindrome.
//             count++;

//             left--;
//             right++;
//         }

//         return count;
//     }
// }