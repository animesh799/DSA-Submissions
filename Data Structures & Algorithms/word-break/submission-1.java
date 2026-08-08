class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        Set<String> set = new HashSet<>();

        int maxLen = 0;

        // Put all dictionary words into HashSet
        // for O(1) average lookup.
        for (String word : wordDict) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        // dp[i] = whether first i characters of s
        // can be formed using words from dictionary.
        boolean[] dp = new boolean[n + 1];

        // Empty string can always be formed.
        dp[0] = true;

        // Try to determine whether first i characters can be formed.
        for (int i = 1; i <= n; i++) {

            int currIdx = i - 1;

            int currStringLen = 1;

            // Check substrings ending at i-1.
            while (currStringLen <= maxLen && currIdx >= 0) {

                // substring(currIdx, i)
                // includes currIdx and ends at i-1.
                String sub = s.substring(currIdx, i);

                // If:
                // 1. Current substring is a dictionary word
                // 2. Everything before it can already be formed
                //
                // Then first i characters can be formed.
                if (set.contains(sub) && dp[currIdx]) {
                    dp[i] = true;
                    break;
                }

                currIdx--;
                currStringLen++;
            }
        }

        return dp[n];
    }
}